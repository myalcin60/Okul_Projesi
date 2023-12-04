package okulProject;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Ogretmen.feykOgretmenEkle();
        Ogrenci.feykOgrenciEkle();

        Depo.anaMenu();
        int sayi= 5;
    }
}
