
public class PruebaLCDE {
    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada<String> miLista=
            new ListaCircularDoblementeEnlazada<String>();
        
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlFinal("A");
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlFinal("B");
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlInicio("C");
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlFinal("D");
        System.out.println(miLista);
        System.out.println(miLista.revisar());        
        miLista.eliminarAlInicio();
        System.out.println(miLista);       
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        System.out.println(miLista.revisar());   
        
    }  
    
}
