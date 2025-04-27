package com.prueba2;

import com.prueba2.db.Database;
import com.prueba2.service.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.init();

        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== LOGIN ====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean login = authService.autenticar(username, password);

        if (login) {
            System.out.println("Login exitoso ✅");
        } else {
            System.out.println("Login fallido ❌");
        }
    }
}
