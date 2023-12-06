package br.ucsal.tcc.avatarizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import br.ucsal.tcc.avatarizer.constantes.Urls;

@Configuration
public class WeatherAPI {

    private String apiUrl = Urls.url;
    
    @Autowired
    private RestTemplate restTemplate;

    public String tratarDadosDaAPI() {
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public String obterDadosDaAPI(String latitude, String longitude) {
    	apiUrl = apiUrl.replace("$latitude$", latitude);
    	apiUrl = apiUrl.replace("$longitude$", longitude);
        return apiUrl;
    }
}