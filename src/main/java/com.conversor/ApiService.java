package com.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private static final String API_KEY = "6b426c26e3caea9f7f999a5b";

    public String obtenerDatos(String monedaBase) {

        String url = "https://v6.exchangerate-api.com/v6/"
                + API_KEY + "/latest/" + monedaBase;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la API");
        }
    }
}