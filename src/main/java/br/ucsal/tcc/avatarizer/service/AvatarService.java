package br.ucsal.tcc.avatarizer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
			String dayOfWeek = dateTime.getDayOfWeek().toString();
			currentWeather.setTemperature_2m(Math.round(currentWeather.getTemperature_2m())+1);

			// Halloween: A roupa do avatar muda para uma fantasia de mumia ou de dracula.
			if (month == 10 && day == 31) {
				// Mumia
				if (month == 10 && day == 31 && hour >= 0 && hour <= 12) {
					Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "007", "TD");
					avatar = avatarOptional.get().getLink();

				} else if (month == 10 && day == 31 && hour >= 12 && hour <= 23 && minute < 58) {
					// Dracula
					Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "008", "TD");
					avatar = avatarOptional.get().getLink();
				}
			} else if (month == 3 && day == 31) {
				// Pascoa: A roupa do avatar muda para um costume de temático de Coelho.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "009", "TD");
				avatar = avatarOptional.get().getLink();
			}else if (month == 12 && day == 31) {
				// Ano Novo (Ultimo dia do ano): A roupa do avatar muda para branco.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "TD");
				avatar = avatarOptional.get().getLink();
			}else if (month == 1 && day == 1 && hour >= 0 && hour <= 7) {
				// Ano Novo (Primeiro dia do ano): A roupa do avatar muda para branco com fogos de artifico no background.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "002", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (month == 8 && day == 11) {
				// Dia do estudante: A roupa do avatar muda para uma roupa de estudante.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "006", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (month == 12 && day == 25) {
				// Natal: A roupa do avatar muda para uma roupa de papai noel.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "012", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (month == 6 && day == 23) {
				// Vespera são João: A roupa do avatar muda para uma roupa de festa junina.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "010", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (month == 6 && day == 24) {
				// Dia do são João: A roupa do avatar muda para uma roupa de festa junina com acessorios.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "011", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (day >= 4 && day <= 7 && month == 2) {
				// Dia 04 ao 07 de fevereiro: A roupa do avatar muda para uma roupa de carnaval com oculos escuros.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "004", "TD");
				avatar = avatarOptional.get().getLink();
			} else if (day >= 8 && day <= 13 && month == 2) {
				// Dia 08 ao 13 de fevereiro: A roupa do avatar muda para uma roupa de carnaval com oculos escuros e confete no fundo.
				Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "003", "TD");
				avatar = avatarOptional.get().getLink();
			} else {
				// Começo das condições não temáticas
				if (currentWeather.getTemperature_2m() <= 22) {
					// Frio
					if (currentWeather.getRain() > 0) {
						// Chovendo
						Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "002", "Cold");
						avatar = avatarOptional.get().getLink();
					} else {
						// Normal
						Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "Cold");
						avatar = avatarOptional.get().getLink();
					}
				} else {
					if (month == 12 || (month >= 1 && month <= 3)) {
						boolean weekend = dayOfWeek.equals("FRIDAY") || dayOfWeek.equals("SATURDAY") || dayOfWeek.equals("SUNDAY");
						if (weekend && (currentWeather.getTemperature_2m() >= 28 && currentWeather.getTemperature_2m() <= 29) && (hour >= 11 && hour <= 14)) {
							// praia de oculos
							Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "004", "Hot");
							avatar = avatarOptional.get().getLink();
						} else if (weekend && (currentWeather.getTemperature_2m() > 29) && (hour >= 11 && hour <= 14)) {
							// Praia oculos calor
							Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "003", "Hot");
							avatar = avatarOptional.get().getLink();
						} else if (weekend && (currentWeather.getTemperature_2m() > 29)) {
							// Praia com calor
							Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "002", "Hot");
							avatar = avatarOptional.get().getLink();
						} else if (weekend && (currentWeather.getTemperature_2m() >= 28 && currentWeather.getTemperature_2m() <= 29)) {
							// Praia
							Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "Hot");
							avatar = avatarOptional.get().getLink();
						} else {
							Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "Base");
							avatar = avatarOptional.get().getLink();
						}
					} else {
						Optional<Avatar> avatarOptional = avatarRepository.findByAvatarCodeAndIdentificationAndType(codigo, "001", "Base");
						avatar = avatarOptional.get().getLink();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avatar;
	}

}
