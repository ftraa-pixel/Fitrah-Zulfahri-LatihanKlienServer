package com.pbi.tk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 5000;

        // 3. Tambahkan keluaran identitas
        System.out.println("=== IDENTITAS ===");
        System.out.println("Nama  : Fitrah Zulfahri");
        System.out.println("NIM   : 25110110");
        System.out.println("Kelas : Teknik Komputer B Pagi");
        System.out.println("=================");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server berjalan, menunggu koneksi di port " + port + " ...");

            while (true) {
                // Menunggu sampai ada klien yang connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Klien terhubung dari: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Membaca pesan yang dikirim klien
                String pesanMasuk = in.readLine();
                System.out.println("Pesan dari klien: " + pesanMasuk);

                // Mengirim balasan ke klien
                out.println("Halo dari Server! Pesan Anda diterima: " + pesanMasuk);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
