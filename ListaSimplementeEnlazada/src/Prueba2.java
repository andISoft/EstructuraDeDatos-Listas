import java.util.Iterator;

public class Prueba2 {
    public static void main(String[] args) {
        ListaSimplementeEnlazada<String> miLista =
                new ListaSimplementeEnlazada<String>();
        miLista.insertarAlInicio("A");       
        miLista.insertarAlInicio("B");
        miLista.insertarAlInicio("C");
        miLista.insertarAlInicio("D");
        miLista.insertarAlInicio("E");        
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        
        miLista.eliminar("C");  //no se puede eliminar E
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        
             
        
        //Iterator miIterador = miLista.iterator();
        
    }
   
}
