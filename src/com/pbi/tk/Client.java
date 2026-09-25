package com.pbi.tk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Terhubung ke server " + host + ":" + port);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Mengirim pesan ke server
            out.println("Halo dari Client!");

            // Menerima balasan dari server
            String balasan = in.readLine();
            System.out.println("Balasan server: " + balasan);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
