public class PruebaLCSE {
    public static void main(String[] args) {
        ListaCircularSimplementeEnlazada<String> miLista = 
                new ListaCircularSimplementeEnlazada<String>();
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlFinal("A");
        System.out.println(miLista);
        System.out.println(miLista.revisar());
        miLista.insertarAlFinal("B");
        System.out.println(miLista);
        miLista.insertarAlFinal("C");
        System.out.println(miLista);
        miLista.insertarAlFinal("D");
        System.out.println(miLista.revisar());
        System.out.println(miLista);
        miLista.eliminarAlInicio();
        System.out.println(miLista);       
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        miLista.eliminarAlFinal();
        System.out.println(miLista);
        System.out.println(miLista.revisar());     
        
    }
    
}
