
import java.util.Iterator;


public class PruebaListaAlumnos {
    public static void main(String[] args) {
        Alumno al01 = new Alumno("001","Benavides Cerro","José Miguel",16);
        Alumno al02 = new Alumno("002","Garavito Kiun","Sandro Pedro",11);
        Alumno al03 = new Alumno("003","Costa Carrillo","Jacinto Esaú",13);
        ListaSimplementeEnlazada<Alumno> alumnos = 
                new ListaSimplementeEnlazada<Alumno>();
        alumnos.insertarAlInicio(al01);
        alumnos.insertarAlInicio(al02);
        alumnos.insertarAlFinal(al03);
        /*for(Alumno x: alumnos){
            System.out.println("Código: " + x.getCodigo());
            System.out.println("Apellidos: " + x.getApellidos());
            System.out.println("Nombres: " + x.getNombres());
            System.out.println("Promedio: " + x.getPromedio());
            System.out.println();
        }   */  
        
        Iterator<Alumno> miIterador = alumnos.iterator();
        
        while(miIterador.hasNext()){
            Alumno aux = miIterador.next();
            System.out.println("Código: " + aux.getCodigo());
            System.out.println("Apellidos: " + aux.getApellidos());
            System.out.println("Nombres: " + aux.getNombres());
            System.out.println("Promedio: " + aux.getPromedio());
            System.out.println();
        }
        
        
    }
}
