package banka_otomasyonu;

public class Hesap extends Banka{
    
    private final static String [] hesap_turleri={"VADELİ","VADESİZ"}; 
    private int hesap_no;
    private String hesap_sifre;
    private String hesap_turu;
    private String banka_adi;
    private int bakiye = 0;
    

    public int getHesap_no() {
        return hesap_no;
    }

    public void setHesap_no(int hesap_no) {
        this.hesap_no = hesap_no;
    }

    public String getHesap_sifre() {
        return hesap_sifre;
    }

    public void setHesap_sifre(String hesap_sifre) {
        this.hesap_sifre = hesap_sifre;
    }

    public String getHesap_turu() {
        return hesap_turu;
    }

    public void setHesap_turu(String hesap_turu) {
        this.hesap_turu = hesap_turu;
    }

    public String getBanka_adi() {
        return banka_adi;
    }

    public void setBanka_adi(String banka_adi) {
        this.banka_adi = banka_adi;
    }

    public int getBakiye() {
        return bakiye;
    }

    public static String[] getHesap_turleri() {
        return hesap_turleri;
    }
    
    
    public void para_yatir(int yatirilan){
        bakiye+= yatirilan;
    }
    public void para_cek(int cekilen){
        if (cekilen<=bakiye){
            bakiye-=cekilen;
        }
        else{
            System.out.println("YETERSİZ BAKİYE");
        }
        
    }
    
    
    
}
