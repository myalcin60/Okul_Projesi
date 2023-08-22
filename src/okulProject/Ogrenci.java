package okulProject;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {
   static Map<String,String> ogrenciMap = new HashMap<>();
   static Scanner scan = new Scanner(System.in);


    public static void feykOgrenciEkle(){
       ogrenciMap.put("9876543210", "Ali, CAn, 2010, 12, A");
       ogrenciMap.put("9876543211", "Ela, Goz, 2011, 12, B");
   }

public static void ogrenciMenu() throws InterruptedException {
       String tercih = "";
       do {


           System.out.println("================ YILDIZ KOLEJI ==================\n" +
                   "================ OGRENCI MENU ===============\n" +
                   "\t     1- Ogrenci listesi\n" +
                   "\t     2_ Soyisimden ogrenci bulma\n" +
                   "\t     3- Sinif ve Sube ile ogrencibulma\n" +
                   "\t     4- Bilgileri girerek ogrenci ekle\n" +
                   "\t     5- Kimlik no ile kayit silme\n" +
                   "\t     A- Ana menu\n" +
                   "\t     Q- Cikis\n");
           tercih=scan.nextLine();
           switch (tercih){
               case "1" : // Ogrenci listesi
                   OgrenciListesi();
                   break;
               case "2" : //Soyisimden ogrenci bulma
                   soyisimOgrenciBulma();
                   break;
               case "3" : // Sinif ve Sube ile ogrencibulma
                   sinifVeSubeIleOgrenciBulma();
                   break;
               case "4" : // Bilgileri girerek ogrenci ekle
                   ogrnciEkle();
                   break;
               case "5" : // Tc ile ogrenci silme
                   ogrenciSilme();
                   break;
               case "a" :
               case "A" :
                  Depo.anaMenu();
                   break;
               case "q" :
               case "Q" :
                   Depo.projeDurdur();
                   break;
           }


       }while (!tercih.equalsIgnoreCase("q"));
       Depo.projeDurdur();

}

    public static void ogrenciSilme() {
        System.out.println("Silinecek ogrenci TC girin");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);

        String sonucValue = ogrenciMap.remove(silinecekOgrenci);
        System.out.println(silinecekOgrenci + " Tc nolu ogrenci silindi");


        try {
            boolean sonuc = sonucValue.equals(sonucValue);
        } catch (Exception e) {
            System.out.println("Girdiginiz TC ile ogrenci bulunamadi");
        }
    }

    public static void ogrnciEkle() {
        System.out.println("Tc no");
        String tcNo = scan.nextLine();
        System.out.println("Isim");
        String isim = scan.nextLine();
        System.out.println("Soy Isim");
        String soyIsim = scan.nextLine();
        System.out.println("Dogum trh");
        String doyumTrh = scan.nextLine();
        System.out.println("Sinif");
        String sinif = scan.nextLine();
        System.out.println("Sube");
        String sube = scan.nextLine();

        String eklenecekValue = isim + ", " + soyIsim +", " + doyumTrh + ", " + sinif + ", " + sube;
        ogrenciMap.put(tcNo, eklenecekValue);
    }

    public static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin sinif ve subesini girin");

        String istenenIsim = scan.nextLine();
        String istenenSube = scan.nextLine();

        Set<Map.Entry<String,String>> ogrenciEntrySet =ogrenciMap.entrySet();

        System.out.println("================ YILDIZ KOLEJI ==================\n"+
                "============= SINIF VE SUBE ILE OGRENCI ARAMA ============\n"+
                "Tc no        Isim   Soyisim   D Yili   Sinif   Sube");

        for (Map.Entry<String,String> each : ogrenciEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuArr[]= eachValue.split(", ");

            if(istenenIsim.equalsIgnoreCase(eachValuArr[3] ) && istenenSube.equalsIgnoreCase(eachValuArr[4] )){

                System.out.printf("%-12s %-6s %-9s %-8s %-7s %-2s \n", eachKey, eachValuArr[0],
                        eachValuArr[1], eachValuArr[2], eachValuArr[3],eachValuArr[4]);
            }


        }
        Thread.sleep(5000);

    }

    public static void soyisimOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin soy ismini girin");

        String istenenSoyisim = scan.nextLine();

        Set<Map.Entry<String,String>> ogrenciEntrySet =ogrenciMap.entrySet();

        System.out.println("================ YILDIZ KOLEJI ==================\n"+
                "============= SOY ISIM ILE OGRENCI ARAMA ============\n"+
                "Tc no        Isim   Soyisim   D Yili   Sinif   Sube");

        for (Map.Entry<String,String> each : ogrenciEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuArr[]= eachValue.split(", ");

            if(istenenSoyisim.equalsIgnoreCase(eachValuArr[1])){
                System.out.printf("%-12s %-6s %-9s %-8s %-7s %-2s \n", eachKey, eachValuArr[0],
                        eachValuArr[1], eachValuArr[2], eachValuArr[3],eachValuArr[4]);
            }


        }
        Thread.sleep(5000);
    }

    public static void OgrenciListesi() throws InterruptedException {
        Set<Map.Entry<String,String>> myEntrySEt =ogrenciMap.entrySet();

        System.out.println("================ YILDIZ KOLEJI ==================\n" +
                "================ OGRENCI MENU ===============\n" +
                "Tc no        Isim   Soyisim   D Yili   Sinif   Sube");
        for(Map.Entry<String,String> each: myEntrySEt)
        {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuArr[] = eachValue.split(", ");

            System.out.printf("%-12s %-6s %-9s %-8s %-7s %-2s \n", eachKey, eachValuArr[0],
                    eachValuArr[1], eachValuArr[2], eachValuArr[3],eachValuArr[4]);
        }
        Thread.sleep(5000);

    }
}
