
import java.util.Iterator;

public class PruebaLSE {

    public static void main(String[] args) {
        ListaSimplementeEnlazada<String> miLista = 
                new ListaSimplementeEnlazada<String>();
        //System.out.println(miLista.ultimo());
        miLista.insertarAlFinal("4");
        //System.out.println(miLista.ultimo());
        miLista.insertarAlFinal("5");
        //System.out.println(miLista.ultimo());
        miLista.insertarAlFinal("6");
        miLista.insertarAlFinal("7");
        System.out.println(miLista);
        System.out.println("Borraste "+miLista.eliminarAlFinal());
        System.out.println(miLista);
        //miLista.anular();
        System.out.println(miLista.revisar());
        //System.out.println(miLista);
        
        
        Iterator miIterador = miLista.iterator();
        
        while(miIterador.hasNext()){
            System.out.println(miIterador.next());
        }

    }    
}
