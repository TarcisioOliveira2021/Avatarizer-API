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

    public void obterDadosDaAPI(String latitude, String longitude) {
    	apiUrl = apiUrl.replace("$latitude$", limparString(latitude));
    	apiUrl = apiUrl.replace("$longitude$", limparString(longitude));
    }

    public String limparString(String string) {
        return string.replaceAll("[^0-9.]", "");
    }

    public void resetUrl() {
    	apiUrl = Urls.url;
    }
}