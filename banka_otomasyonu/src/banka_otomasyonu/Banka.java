package banka_otomasyonu;

abstract class Banka {
    private final static String[] bankalar = {"İŞ BANKASI","GARANTİ BANKASI","ZİRAAT BANKASI"};

    public static String[] getBankalar() {
        return bankalar;
    }
    
}
