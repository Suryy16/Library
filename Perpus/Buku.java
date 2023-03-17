package Perpus;

import java.text.DecimalFormat;

public class Buku {
    String namaBuku;
    String penulis;
    String kategori;
    String sinopsis;
    double hargaBuku;
    double persen;
    double penjualan;
    String pattern = "###,###.###";
    DecimalFormat format = new DecimalFormat(pattern);

    Buku(String namaBuku, String penulis, String kategori, String sinopsis, double hargaBuku, double persen, double penjualan) {
        this.namaBuku = namaBuku;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis.toLowerCase();
        this.hargaBuku = hargaBuku;
        this.persen = persen;
        this.penjualan = penjualan;
    }

    void display() {

        System.out.println("Judul\t\t\t\t\t\t: " + namaBuku);
        System.out.println("Penulis\t\t\t\t\t\t: " + penulis);
        System.out.println("Kategori\t\t\t\t\t: " + kategori);
        System.out.println("Sinopsis \t\t\t\t\t: " + sinopsis);
        System.out.println("Jumlah kata pada sinopsis\t: " + hitungJumlahKataSinopsis());
        System.out.println("Royalti 10%\t\t\t\t\t: " + "Rp. " + format.format((long)hitungRoyalti(hargaBuku, penjualan)));
        System.out.println("Royalti " + persen + "%\t\t\t\t: " + "Rp. " + format.format((long)hitungRoyalti(hargaBuku, persen, penjualan)));
        System.out.println();
    }

    void perbaikiSinopsis() {
        String[] sentences = sinopsis.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (sentence.length() > 0) {
                sb.append(Character.toUpperCase(sentence.charAt(0)));
                sb.append(sentence.substring(1));
                sb.append(". ");
            }
        }
        sinopsis = sb.toString().trim();
    }

    int hitungJumlahKataSinopsis() {
        return sinopsis.split("\\s+").length;
    }

    double hitungRoyalti(double hargaBuku, double penjualan) {
        this.hargaBuku = hargaBuku;
        this.penjualan = penjualan;
        return 0.1 * this.hargaBuku * this.penjualan;
    }

    double hitungRoyalti(double hargaBuku, double persen, double penjualan) {
        this.persen = persen;
        this.hargaBuku = hargaBuku;
        this.penjualan = penjualan;
        return persen / 100 * this.hargaBuku * this.penjualan;
    }

}
