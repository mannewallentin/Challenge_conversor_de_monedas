package com.conversor;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        System.out.println("=== CONVERSOR DE MONEDAS ===");

// Usamos USD solo para mostrar la lista
        conversor.mostrarMonedasDisponibles("USD");

        System.out.print("Moneda origen (ej: USD): ");
        String origen = scanner.nextLine().toUpperCase();
        System.out.print("Moneda destino (ej: PEN): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Monto: ");
        double monto = scanner.nextDouble();

        double resultado = conversor.convertir(origen, destino, monto);

        System.out.println("Resultado: " + resultado + " " + destino);
    }
}
