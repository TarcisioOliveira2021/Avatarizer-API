package br.ucsal.tcc.avatarizer.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.ucsal.tcc.avatarizer.repository.AvatarRepository;
import org.springframework.stereotype.Component;

import br.ucsal.tcc.avatarizer.modal.Avatar;
import jakarta.annotation.PostConstruct;

@Component
public class DefaultDataBase {

    private final AvatarRepository avatarRepository;

    private String caminhoArquivo = ".//database.txt";

    public DefaultDataBase(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    @PostConstruct
    private void inserirDatabase() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            Map<String, Avatar> mapAvatar = avatarRepository.findAll().stream()
                    .collect(Collectors.toMap(Avatar::getFileName, avatar -> avatar));
            while ((linha = br.readLine()) != null) {
                Avatar avatar = parseAvatar(linha);

                if (avatar != null && !mapAvatar.containsKey(avatar.getFileName())){
                    avatarRepository.save(avatar);
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
                if (!type.isEmpty() && !identification.isEmpty() && !definition.isEmpty()) {
                    return new Avatar(fileName, avatarCode, type, identification, definition, "", link);
                } 
            }
        } catch (Exception e) {
            System.err.println("Erro ao analisar avatarInfo: " + avatarInfo);
            e.printStackTrace();
            return null;
        }
		return null;
    }
}
