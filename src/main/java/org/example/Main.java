package org.example;

import Vistas.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de notas de estudiantes.");

        // Crear instancia del menú principal
        Menu menu = new Menu();

        try {
            // Iniciar el menú para que el usuario pueda interactuar
            menu.iniciarMenu();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error durante la ejecución del programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
