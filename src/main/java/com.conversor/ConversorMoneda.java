package com.conversor;

import com.google.gson.Gson;

public class ConversorMoneda {

    private ApiService apiService = new ApiService();
    private Gson gson = new Gson();

    public double convertir(String origen, String destino, double monto) {

        String json = apiService.obtenerDatos(origen);
        Moneda moneda = gson.fromJson(json, Moneda.class);

        double tasa = moneda.getConversion_rates().get(destino);
        return monto * tasa;
    }

    public void mostrarMonedasDisponibles(String monedaBase) {

        String json = apiService.obtenerDatos(monedaBase);
        Moneda moneda = gson.fromJson(json, Moneda.class);

        System.out.println("Monedas disponibles:");

        for (String codigo : moneda.getConversion_rates().keySet()) {
            System.out.print(codigo + " ");
        }

        System.out.println();
    }
}


