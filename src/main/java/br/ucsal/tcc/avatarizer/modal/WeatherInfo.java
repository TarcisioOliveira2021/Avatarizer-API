package br.ucsal.tcc.avatarizer.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    private CurrentWeather current;

	public CurrentWeather getCurrent() {
		return current;
	}

	public void setCurrent(CurrentWeather current) {
		this.current = current;
	}
    
}