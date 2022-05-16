import java.io.Serializable;

public class Ksiazka implements Serializable {

    private int isbn;
    private String tytul, autor;

    public Ksiazka() {
        isbn=0;
        tytul=null;
        autor=null;
    }

    public Ksiazka(int isbn, String tytul, String autor) {
        this.isbn=isbn;
        this.tytul=tytul;
        this.autor=autor;
    }

    @Override
    public String toString() {
        return "\nisbn: "+isbn+"\nTytul: "+tytul+"\nAutor: "+autor+"\n";
    }
}
