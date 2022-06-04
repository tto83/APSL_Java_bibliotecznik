import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Biblioteka implements Serializable{

    private List<Ksiazka> zasoby;

    public Biblioteka() {
        zasoby = new ArrayList<Ksiazka>();
    }

    public void dodaKsiazke(Ksiazka ksiazka){
        zasoby.add(ksiazka);
    }

    @Override
    public String toString(){
        String temp="/n";

        Iterator<Ksiazka> i = zasoby.iterator();
        while(i.hasNext()){
            Ksiazka k = (Ksiazka) i.next();
            temp = temp + k.toString();
        }

        return temp;
    }

}
