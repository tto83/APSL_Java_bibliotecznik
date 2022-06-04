import java.io.*;
import java.util.Scanner;

public class MainSystem {

    static String plik = null;
    static Biblioteka bib = new Biblioteka();
    static Scanner in = new Scanner(System.in);
    static Boolean runFlag = true;

    public static void main(String[] args) {
        while(runFlag){
            System.out.println(
                    "\n0 - Wczytanie biblioteki" +
                    "\n1 - Zapis i wyjscie"+
                    "\n2 - Lista ksiazek w bibliotece"+
                    "\n3 - Dodaj ksiazke");

            int prompt = in.nextInt();
            switch (prompt) {
                case 0:
                    System.out.println("Podaj nazwe pliku");
                    wczytajSkrypt(in.next());
                    break;

                case 1:
                    zapiszWyjdz();
                    break;

                case 2:
                    System.out.println(bib.toString());
                    break;

                case 3:
                    dodajKsiazke();
                    break;

            }
        }
        System.exit(0);
    }

    private static void dodajKsiazke() {
        int isbn;
        String tytul, autor;

        System.out.println("\nPodaj tytul:");
        tytul = in.next();

        System.out.println("\nPodaj autora:");
        autor = in.next();

        System.out.println("\nPodaj ISBN:");
        isbn = in.nextInt();

        Ksiazka k = new Ksiazka(isbn, tytul, autor);
        bib.dodaKsiazke(k);
    }

    private static void zapiszWyjdz() {
        System.out.println("Podaj nazwe pliku");
        plik = in.next()+".ser";
        runFlag = false;

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(plik);
            out = new ObjectOutputStream(fos);
            out.writeObject(bib);
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void wczytajSkrypt(String plik) {
        FileInputStream fis = null;
        ObjectInputStream in = null;

        File file = new File(plik+".ser");
        if(file.exists()){
            try{
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                bib = (Biblioteka) in.readObject();
                fis.close();
                in.close();

            } catch(FileNotFoundException | ClassNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("\nPlik nie istnieje");
        }
    }
}
