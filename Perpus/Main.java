package Perpus;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] jumlahBuku = new int[7];
        String[] kategoriBuku = {"Teknologi", "Filsafat", "Sejarah", "Agama", "Psikologi", "Politik", "Fiksi"};
        Buku[] sumbangan;

        for (int i = 0; i < kategoriBuku.length; i++) {
            System.out.print("Masukkan jumlah buku " + kategoriBuku[i] + " : ");
            jumlahBuku[i] = in.nextInt();
            in.nextLine();
            System.out.println("=============================================");

            sumbangan = new Buku[jumlahBuku[i]];
            System.out.println("Buku " + kategoriBuku[i] + " : ");
            for (int j = 0; j < jumlahBuku[i]; j++) {
                System.out.println("Masukkan judul buku: ");
                String namaBuku = in.nextLine();
                System.out.println("Masukkan penulis buku: ");
                String penulis = in.nextLine();
                System.out.println("Masukkan sinopsis buku: ");
                String sinopsis = in.nextLine();
                System.out.println("Masukkan Harga Buku: ");
                double hargaBuku = in.nextDouble(); in.nextLine();
                System.out.println("Masukkan persen royalti buku: ");
                double persen = in.nextDouble(); in.nextLine();
                System.out.println("Masukkan Jumlah Buku yang Terjual Bulan ini: ");
                double penjualan = in.nextDouble(); in.nextLine();
                sumbangan[j] = new Buku(namaBuku, penulis, kategoriBuku[i], sinopsis, hargaBuku, persen, penjualan);
                sumbangan[j].perbaikiSinopsis();
                System.out.println("=============================================");
            }
            System.out.println("Daftar buku " + kategoriBuku[i] + " yang Anda sumbangkan : ");
            for (int j = 0; j < jumlahBuku[i]; j++) {
                System.out.println((j + 1) + ".");
                sumbangan[j].display();
                System.out.println("=============================================");
            }
        }
    }
}

