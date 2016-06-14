package banka_otomasyonu;

import java.util.Scanner;

public class main_class {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ana_menu();        
    }

    public static void ana_menu() {
        System.out.println();
        System.out.println("KAYIT İÇİN --> 1");
        System.out.println("GİRİŞ İÇİN --> 2");
        System.out.println("ÇIKIŞ İÇİN --> 3\n");
        System.out.print("SEÇİM : ");
                
        switch (scanner.nextInt()) {
            case 1:
                Musteri.kayit_ol();
                break;
            case 2:
                System.out.print("\nMÜŞTERİ NO : ");
                String no = scanner.next();
                System.out.print("MÜŞTERİ ŞİFRESİ : ");
                String sifre = scanner.next();
                Musteri.giris_yap(no, sifre);
                break;
        }
    }

}
