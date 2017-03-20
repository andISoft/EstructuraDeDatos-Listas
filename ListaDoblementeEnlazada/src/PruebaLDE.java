public class PruebaLDE {
    public static void main(String[] args) {
        ListaDoblementeEnlazada<String> miLis = 
                new ListaDoblementeEnlazada<String>();
        System.out.println(miLis.revisar());
        miLis.insertarAlInicio("A");
        System.out.println(miLis.revisar());        
        miLis.insertarAlInicio("B");
        miLis.insertarAlInicio("C");
        miLis.insertarAlFinal("D");        
        System.out.println(miLis);        
        System.out.println(miLis.revisar());
        System.out.println(miLis.ultimo());
        
        miLis.eliminarAlInicio();
        System.out.println(miLis);
        System.out.println(miLis.revisar());
        miLis.eliminarAlFinal();
        System.out.println(miLis);
        System.out.println(miLis.revisar());
        System.out.println(miLis.ultimo());
        
        miLis.eliminarAlFinal();
        System.out.println(miLis);
        System.out.println(miLis.revisar());
        miLis.eliminarAlInicio();
        System.out.println(miLis);
        System.out.println(miLis.revisar());
    }

}
