package br.ucsal.tcc.avatarizer.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import br.ucsal.tcc.avatarizer.modal.Avatar;
import jakarta.annotation.PostConstruct;

@Component
public class DefaultDataBase {

    private String caminhoArquivo = ".//database.txt";

    @PostConstruct
    private void inserirDatabase() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Avatar avatar = parseAvatar(linha);

                if (avatar != null) {
                    System.out.println(avatar);
                    insertAvatarIntoDatabase(avatar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Avatar parseAvatar(String avatarInfo) {
        try {
            String[] bigpart = avatarInfo.split(" - ");
            String[] parts = bigpart[0].split("_");
            if (parts.length >= 5) {
                String fileName = parts[0] + "_" + parts[1] + "_" + parts[2] + "_" + parts[3];
                String avatarCode = parts[0] + "_" + parts[1];
                String type = parts[2];
                String identification = parts[3];
                String definition = parts[4];
                String link = bigpart[1];
                
                // Verifica se todas as partes necessárias estão presentes
                if (!fileName.isEmpty() && !avatarCode.isEmpty() && !type.isEmpty() && !identification.isEmpty() && !definition.isEmpty()) {
                    return new Avatar(null, fileName, avatarCode, type, identification, definition, "", link);
                } 
            }
        } catch (Exception e) {
            System.err.println("Erro ao analisar avatarInfo: " + avatarInfo);
            e.printStackTrace();
            return null;
        }
		return null;
    }




    private void insertAvatarIntoDatabase(Avatar avatar) {
        // Verifica se o avatar é nulo antes de prosseguir
        if (avatar != null) {
            String sql = "INSERT INTO avatar_table (avatar_code, definition, description, file_name, identification, link, type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/avatarizer",
                    "postgres", "@liss0n2912M");
                 PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"})) {

                pstmt.setString(1, avatar.getAvatarCode());
                pstmt.setString(2, avatar.getDefinition());
                pstmt.setString(3, avatar.getDescription());
                pstmt.setString(4, avatar.getFileName());
                pstmt.setString(5, avatar.getIdentification());
                pstmt.setString(6, avatar.getLink());
                pstmt.setString(7, avatar.getType());
                pstmt.executeUpdate();

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        Long generatedId = generatedKeys.getLong(1);
                        avatar.setId(generatedId);
                    } else {
                        throw new SQLException("Failed to retrieve generated ID.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
