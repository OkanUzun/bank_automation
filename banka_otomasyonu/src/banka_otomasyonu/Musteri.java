package banka_otomasyonu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Musteri {

    private String mus_isim;
    private String mus_soyisim;
    private String mus_no;
    private String mus_sifre;
    private static List<Musteri> musteriler = new ArrayList<>(); // Müşterilerin tutuldugu list
    private List<Hesap> hesaplar = new ArrayList<>(); // Her bir müşterinin hesaplarının tutuldugu list
    static Scanner scanner = new Scanner(System.in);
    private static Musteri m; // Müşteri nesnesi
    private Hesap h; //Hesap nesnesi

    public String getMus_isim() {
        return mus_isim;
    }

    public void setMus_isim(String mus_isim) {
        this.mus_isim = mus_isim;
    }

    public String getMus_soyisim() {
        return mus_soyisim;
    }

    public void setMus_soyisim(String mus_soyisim) {
        this.mus_soyisim = mus_soyisim;
    }

    public String getMus_no() {
        return mus_no;
    }

    public void setMus_no(String mus_no) {
        this.mus_no = mus_no;
    }

    public String getMus_sifre() {
        return mus_sifre;
    }

    public void setMus_sifre(String mus_sifre) {
        this.mus_sifre = mus_sifre;
    }

    public static List<Musteri> getMusteriler() {
        return musteriler;
    }

    public static void setMusteriler(List<Musteri> musteriler) {
        Musteri.musteriler = musteriler;
    }

    public List<Hesap> getHesaplar() {
        return hesaplar;
    }

    public void setHesaplar(List<Hesap> hesaplar) {
        this.hesaplar = hesaplar;
    }

    public static Musteri getM() {
        return m;
    }

    public static void setM(Musteri m) {
        Musteri.m = m;
    }

    public Hesap getH() {
        return h;
    }

    public void setH(Hesap h) {
        this.h = h;
    }

    public static void hesaplari_goruntule() {

        if (m.hesaplar.isEmpty()) {
            System.out.println("HENÜZ AÇILMIŞ HESABINIZ BULUNMAMAKTADIR");
            System.out.println("\nHESAP AÇMAK İSTER MİSİNİZ?\n");
            System.out.println("EVET --> 1\nHAYIR --> 2");
            System.out.print("\nSEÇİM : ");
            switch (scanner.nextInt()) {
                case 1:
                    m.hesap_ac();
                    break;
                case 2:
                    main_class.ana_menu();
            }
        } else {
            System.out.println("HESAPLARINIZ\n");
            int toplam_bakiye = 0;
            for (Hesap x : m.hesaplar) {
                toplam_bakiye += x.getBakiye();
                System.out.println("BANKA ADI : " + x.getBanka_adi() + "\nHESAP NO : " + x.getHesap_no());
                System.out.println("HESAP TÜRÜ : " + x.getHesap_turu() + "\nHESAP BAKİYESİ : " + x.getBakiye());
                System.out.println();

            }
            System.out.println("TOPLAM HESAP SAYINIZ : " + m.hesaplar.size());
            System.out.println("HESAPLARINIZIN TOPLAM BAKİYESİ : " + toplam_bakiye);
            System.out.println("\nHESAP İŞLEMLERİNİZ İÇİN --> 1");
            System.out.println("YENİ BİR HESAP AÇMAK İÇİN --> 2");
            System.out.println("ANA MENUYE DONMEK ICIN --> 3\n");
            System.out.print("SEÇİM : ");
            switch (scanner.nextInt()) {
                case 1:
                    hesap_bilgilerini_gir();
                    break;
                case 2:
                    m.hesap_ac();
                    break;
                case 3:
                    main_class.ana_menu();
                    break;
            }
        }

    }

    public static void kayit_ol() {
        m = new Musteri();
        System.out.print("\nADINIZ : ");
        m.setMus_isim(scanner.next());
        System.out.print("SOYADINIZ : ");
        m.setMus_soyisim(scanner.next());
        System.out.print("MÜŞTERİ NUMARANIZ : ");
        m.setMus_no(scanner.next());
        System.out.print("ŞİFRENİZ : ");
        m.setMus_sifre(scanner.next());
        musteriler.add(m);
        main_class.ana_menu();
    }

    public static void hesap_ac() {
        System.out.println("\nHANGİ BANKADA HESAP AÇMAK İSTERSİNİZ?");
        System.out.println("\nİŞ BANKASI İÇİN --> 1\nGARANTİ BANKASI İÇİN --> 2\nZİRAAT BANKASI İÇİN --> 3");
        System.out.print("\nSEÇİM : ");

        switch (scanner.nextInt()) {
            case 1:
                m.h = new Hesap();
                m.h.setBanka_adi(Banka.getBankalar()[0]);
                m.hesaplar.add(m.h);
                break;
            case 2:
                m.h = new Hesap();
                m.h.setBanka_adi(Banka.getBankalar()[1]);
                m.hesaplar.add(m.h);
                break;
            case 3:
                m.h = new Hesap();
                m.h.setBanka_adi(Banka.getBankalar()[2]);
                m.hesaplar.add(m.h);
                break;
            default:
                return;
        }
        System.out.print("\nHESAP NUMARANIZI GİRİNİZ : ");
        m.h.setHesap_no(scanner.nextInt());

        System.out.print("HESAP ŞİFRENİZİ GİRİNİZ : ");
        m.h.setHesap_sifre(scanner.next());

        System.out.println("\nHESABINIZIN TÜRÜNÜ SECINIZ\n");
        System.out.println("VADELİ HESAP ICIN --> 1");
        System.out.println("VADESİZ HESAP İÇİN --> 2\n");
        System.out.print("SEÇİM : ");

        switch (scanner.nextInt()) {
            case 1:
                m.h.setHesap_turu(Hesap.getHesap_turleri()[0]);
                break;
            case 2:
                m.h.setHesap_turu(Hesap.getHesap_turleri()[1]);
                break;
            default:
                return;
        }

        System.out.println("\nHESABINIZ AÇILMIŞTIR !");
        while (true) {
            hesap_islem_menu();
        }
    }

    public static void giris_yap(String no, String sifre) {
        boolean kontrol = false;
        for (Musteri x : musteriler) {
            if (x.getMus_no().equals(no) && x.getMus_sifre().equals(sifre)) {
                kontrol = true;
                m = x; //Müşteri nesnesini ayarlar                
                break;
            }
        }
        if (kontrol) {
            System.out.println("\nGİRİŞ BAŞARILI\n");
            m.hesaplari_goruntule();
        } else {
            System.out.println("\nMÜŞTERİ NOSU VEYA ŞİFRE YANLIŞ\n");
            main_class.ana_menu();
        }
        System.out.println();
    }

    public static void hesap_bilgilerini_gir() {
        System.out.print("HESAP NO : ");
        int hes_no = scanner.nextInt();
        System.out.print("HESAP SIFRE : ");
        String hes_sifre = scanner.next();
        hesap_giris_kontrol(hes_no, hes_sifre);
    }

    public static void hesap_giris_kontrol(int hes_no, String hes_sifre) {
        boolean kontrol = false;
        for (Hesap x : m.hesaplar) {
            if (x.getHesap_no() == hes_no && x.getHesap_sifre().equals(hes_sifre)) {
                m.h = x;
                kontrol = true;
                break;
            }
        }
        if (kontrol) {
            hesap_bilgileri();
        } else {
            System.out.println("BÖYLE BİR HESABINIZ BULUNMAMAKTADIR");
        }

    }

    public static void hesap_bilgileri() {
        System.out.println("BANKA ADI : " + m.h.getBanka_adi() + "\nHESAP NO : " + m.h.getHesap_no());
        System.out.println("HESAP TÜRÜ : " + m.h.getHesap_turu() + "\nHESAP BAKİYESİ : " + m.h.getBakiye());
        System.out.println();
        hesap_islem_menu();

    }

    public static void hesap_islem_menu() {
        System.out.println("NE YAPMAK İSTEDİĞİNİZİ SEÇİNİZ");
        System.out.println("BAKİYENİZİ GÖRMEK İÇİN --> 1");
        System.out.println("PARA YATIRMAK İÇİN --> 2");
        System.out.println("PARA ÇEKMEK İÇİN --> 3");
        System.out.println("ANA MENÜYE DÖNMEK İÇİN --> 4\n");
        hesap_islem_sec();
    }

    public static void hesap_islem_sec() {
        System.out.print("SEÇİM : ");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("\nBAKİYENİZ : " + m.h.getBakiye());
                break;
            case 2:
                System.out.print("\nYATIRMAK İSTEDİGİNİZ TUTARI GİRİNİZ : ");
                m.h.para_yatir(scanner.nextInt());
                break;
            case 3:
                System.out.print("\nÇEKMEK İSTEDİĞİNİZ TUTARI GİRİNİZ : ");
                m.h.para_cek(scanner.nextInt());
                break;
            case 4:
                main_class.ana_menu();
        }
    }

}
