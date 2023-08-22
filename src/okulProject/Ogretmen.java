package okulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String , String> ogretmenlerMap = new HashMap<>();
    public static void feykOgretmenEkle(){
        ogretmenlerMap.put("1234567890", "Ali, Yahya, 1985, Matematik");
        ogretmenlerMap.put("1234567891", "Meryem, Ela, 1988, Sinif");
    }


    public static void ogretmenMenu() throws InterruptedException {
        String tercih ="";
        do {
            System.out.println("================ YILDIZ KOLEJI ==================\n"+
                    "================ OGRETMEN MENU ===============\n"+
                    "\n" +
                    "\t     1-Ogretmen listesi\n" +
                    "\t     2_ Soyisimden ogretmen bulma\n" +
                    "\t     3- Branstan ogretmen bulma\n" +
                    "\t     4-Bilgileri girerek ogretmn ekle\n" +
                    "\t     5-Kimlik no ile kayit sil\n" +
                    "\t     A- ana menu\n" +
                    "\t     Q- cikis\n");
            tercih= scan.nextLine();
            switch (tercih){
                case "1" : // ogretmen listesi
                    ogretmenListesiYazdir();
                    break;
                case "2" :  // Soyisimden ogretmen bulma
                    SoyisimdenOgretmenBulma();

                    break;
                case "3" : // Branstan ogretmen bulma
                    BranstanOgretmenBulma();
                    break;
                case "4" : // Bilgileri girerek ogretmn ekle
                    ogretmenEkleme();
                    break;
                case "5" : // Kimlik no ile kayit sil

                    tcIleOgretmenSil();
                    break;
                case "a" :
                case "A" :
                    Depo.anaMenu();
                    break;
                case "q" :
                case "Q" :
                    break;
                default:
                    System.out.println("lutfen gecerli tercih yapiniz");
            }

        }while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void tcIleOgretmenSil() {
        System.out.println("Silinecek ogretmen TC girin");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);

        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        try {
            boolean sonuc = sonucValue.equals(sonucValue);
        } catch (Exception e) {
            System.out.println("Girdiginiz TC ile ogretmen bulunamadi");
        }
    }

    public static void ogretmenEkleme() {
        System.out.println("Tc no");
        String tcNo = scan.nextLine();
        System.out.println("Isim");
        String isim = scan.nextLine();
        System.out.println("Soy Isim");
        String soyIsim = scan.nextLine();
        System.out.println("Dogum trh");
        String doyumTrh = scan.nextLine();
        System.out.println("Brans");
        String brans = scan.nextLine();

        String eklenecekValue = isim + ", " + soyIsim +", " + doyumTrh + ", " + brans;
        ogretmenlerMap.put(tcNo, eklenecekValue);

    }

    public static void BranstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogretmenin Bransini ismini girin");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String,String>> ogremenEntrySet =ogretmenlerMap.entrySet();
        System.out.println("================ YILDIZ KOLEJI ==================\n"+
                "============= BRANS ILE OGRETMEN ARAMA ============\n"+
                "TC           Isim      Soyisim   Dogum Trh   Brans");

        for (Map.Entry<String,String> each : ogremenEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[]= eachValue.split(", ");

            if(istenenSoyisim.equalsIgnoreCase(eachValuarr[3])){
                System.out.printf("%11s  %-6s    %-8s  %4s        %s \n" , eachKey, eachValuarr[0], eachValuarr[1],
                        eachValuarr[2], eachValuarr[3]);
            }


        }
        Thread.sleep(5000);

    }

    public static void SoyisimdenOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogretmenin soy ismini girin");
        String istenenSoyisim = scan.nextLine();
        Set<Map.Entry<String,String>> ogremenEntrySet =ogretmenlerMap.entrySet();
        System.out.println("================ YILDIZ KOLEJI ==================\n"+
                "============= SOY ISIM ILE OGRETMEN ARAMA ============\n"+
                "TC           Isim      Soyisim   Dogum Trh   Brans");

        for (Map.Entry<String,String> each : ogremenEntrySet) {

            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[]= eachValue.split(", ");

            if(istenenSoyisim.equalsIgnoreCase(eachValuarr[1])){
                System.out.printf("%11s  %-6s    %-8s  %4s        %s \n" , eachKey, eachValuarr[0], eachValuarr[1],
                    eachValuarr[2], eachValuarr[3]);
            }


        }
        Thread.sleep(5000);

    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

      Set<Map.Entry<String,String>> ogremenEntrySet =ogretmenlerMap.entrySet();
        System.out.println("================ YILDIZ KOLEJI ==================\n"+
                "================ OGRETMEN LISTESI ===============\n"+
                "TC           Isim      Soyisim   Dogum Trh   Brans");

     for (Map.Entry<String,String> each : ogremenEntrySet) {

         String eachKey = each.getKey();
         String eachValue = each.getValue();

         String eachValuarr[]= eachValue.split(", ");

         System.out.printf("%11s  %-6s    %-8s  %4s        %s \n" , eachKey, eachValuarr[0],
                 eachValuarr[1], eachValuarr[2], eachValuarr[3]);


       }
     Thread.sleep(5000);

    }
}
