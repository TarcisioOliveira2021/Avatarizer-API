package br.ucsal.tcc.avatarizer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ucsal.tcc.avatarizer.modal.Avatar;
import br.ucsal.tcc.avatarizer.modal.CurrentWeather;
import br.ucsal.tcc.avatarizer.modal.WeatherInfo;
import br.ucsal.tcc.avatarizer.repository.AvatarRepository;

@Service
public class AvatarService {

	private final WeatherAPI weatherAPI;
	
    private final AvatarRepository avatarRepository;


	public AvatarService(WeatherAPI weatherAPI, AvatarRepository avatarRepository) {
		super();
		this.weatherAPI = weatherAPI;
		this.avatarRepository = avatarRepository;
	}


	public String filtro(String codigo, String latitude, String longitude) {
		String avatar = "";
		weatherAPI.obterDadosDaAPI(latitude, longitude);
		String jsonString = weatherAPI.tratarDadosDaAPI();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			WeatherInfo weatherInfo = objectMapper.readValue(jsonString, WeatherInfo.class);

			CurrentWeather currentWeather = weatherInfo.getCurrent();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(currentWeather.getTime(), formatter);

			// int year = dateTime.getYear();
			int month = dateTime.getMonthValue();
			int day = dateTime.getDayOfMonth();
			int hour = dateTime.getHour();
			int minute = dateTime.getMinute();

			if (currentWeather.getRain() > 0) {
				avatar = "Dia Chuvoso: Há alterações na expressão e background do avatar.";
			} else if (currentWeather.getTemperature_2m() <= 22) {
				avatar = "Temperatura Baixa: O avatar do usuário muda a expressão para de frio.";
			} else if (currentWeather.getTemperature_2m() <= 22 && currentWeather.getRain() > 0) {
				avatar = "Temperatura Baixa e Chovendo: O avatar do usuário muda a expressão para de frio e segura um guarda chuva na chuva.";
			} else {

				if (month == 12 || month >= 1 && month <= 3) {
					Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "Hot");
					avatar = avatarOptional.get().getLink();
				} else if (month == 10 && day == 31) {
					avatar = "Halloween: A roupa do avatar muda para um costume de Halloween.";
				} else if (month == 3 && day == 31) {
					avatar = "Pascoa: A roupa do avatar muda para um costume de temático de Coelho.";
				} else if (month == 12 && day == 31) {
					avatar = "Ano Novo: A roupa do avatar muda para branco.";
				} else if (month == 8 && day == 11) {
					avatar = "Dia Estudante: A roupa do avatar muda para uniforme escolar.";
				} else if (month == 12 && day == 25) {
					avatar = "Natal: A roupa do avatar muda para a roupa de papai noel.";
					/*
					 * } else if (true) { // Caso seja sexta-feira, sábado ou domingo e a
					 * temperatura no momento for igual 28 e 29°C avatar =
					 * "O avatar do usuário muda para roupas de praia comóculos de sol."; } else if
					 * (true) { // Caso seja sexta-feira, sábado ou domingo e a temperatura
					 * registrada no momento seja maior que 29°C avatar =
					 * "O avatar do usuário muda a expressão para de calor e fica com as roupas de praia e óculos de sol."
					 * ; } else if (true) { // Caso seja segunda, terça, quarta ou quinta e a
					 * temperatura registrada no momento for igual 28 e 29°Cavatar =
					 * "O avatar do usuário para roupas de praia."; } else if (true) { // Caso seja
					 * segunda, terça, quarta ou quinta e a temperatura registrada no momento seja
					 * maior que 29°C avatar =
					 * "O avatar do usuário muda a expressão para de calor e fica com as roupas de praia."
					 * ;
					 */
				} else if (month == 6 && day == 24) {
					avatar = "O avatar do usuário muda a roupa para entrar no clima de São João.";
				} else if (month == 10 && day == 31 && hour >= 0 && hour <= 12) {
					avatar = "O avatar do usuário muda para o costume de múmia.";
				} else if (month == 10 && day == 31 && hour >= 12 && hour <= 23 && minute < 58) {
					avatar = "O avatar do usuário muda para o costume de Drácula.";
				} else if (month == 12 && day == 31 && hour >= 0 && minute < 59) {
					avatar = "O avatar do usuário muda para roupa Branca.";
				} else if (month == 1 && day == 1 && hour >= 0 && hour <= 7) {
					avatar = "O avatar do usuário muda para roupa Branca e o fundo aparece fogos de artificio.";
				} else if (day >= 4 && day <= 7 && month == 2) {
					avatar = "O avatar do usuário muda para roupa de carnaval com óculos escuros.";
				} else if (day >= 8 && day <= 13 && month == 2) {
					avatar = "O avatar do usuário muda para roupa de carnaval com óculos escuros e confete no fundo.";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return avatar;
	}

}
