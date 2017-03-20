import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoblementeEnlazada<Tipo> implements Iterable<Tipo> {
    private int N;          // tamaño de la lista
    private Nodo inicio;     // inicio de la lista

    private class Nodo {
        private Tipo item;
        private Nodo prox;
        private Nodo ante;
    }

    public ListaDoblementeEnlazada() {
        inicio = null;
        N = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int tamanno() {
        return N;
    }

    public void insertarAlInicio(Tipo item) {
        Nodo inicioPasado = inicio;
        inicio = new Nodo();
        inicio.item = item;
        inicio.ante = null;
        inicio.prox = inicioPasado;
        if(N!=0) inicioPasado.ante = inicio;
        N++;
    }

    public Tipo eliminarAlInicio() {
        if (estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Tipo item = inicio.item;        // guarda item a devolver
        inicio = inicio.prox;           // borra el primer nodo
        if (N!=1) inicio.ante = null;        
        N--;
        return item;                    // devuelve el item guardado
    }
   
    public void insertarAlFinal(Tipo item){
        Nodo penultimo=null;
        
        if (estaVacia()){ 
            insertarAlInicio(item);            
        }
       
        for (Nodo x = inicio; x != null; x = x.prox) {
            penultimo = x;
        }    
        
        Nodo ultimo = new Nodo();
        ultimo.item = item;
        ultimo.prox = null;
        ultimo.ante = penultimo;
        penultimo.prox = ultimo;
        N++;
    }
    
    public Tipo eliminarAlFinal() {
        if (estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Nodo penultimo=null; 
        Tipo item;
        if(inicio.prox == null){
            item = inicio.item;
            inicio = null;
            N--;
            return item;            
        }
        for (Nodo x = inicio; x.prox != null; x = x.prox) {
            penultimo = x;
        }   
        item = penultimo.prox.item;
        penultimo.prox = null;    
        N--;
        return item;                    
    }
    

//    Devuelve el primer item pero no lo elimina
    public Tipo primero() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return inicio.item;
    }
    
    public Tipo ultimo(){
        Nodo ultimo=null;
        
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        
        if(inicio.prox == null)
            return inicio.item;
        
        for (Nodo x = inicio; x != null; x = x.prox) {
            ultimo = x;
        }    
        return ultimo.item;
    }

//    Devuelve una representación de cadena de esta lista
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Tipo item : this)
            s.append(item + " ");
        return s.toString();
    }
       
    public Iterator<Tipo> iterator()  { 
        return new IteradorInicioAlFinal();  
    }

    private class IteradorInicioAlFinal implements Iterator<Tipo> {
        private Nodo actual = inicio;
        
        public boolean hasNext() {
            return actual != null;                     
        }
        
        public void remove(){ throw new UnsupportedOperationException();  }

        public Tipo next() {
            if (!hasNext()) throw new NoSuchElementException();
            Tipo item = actual.item;
            actual = actual.prox; 
            return item;
        }
    }
    public void anular(){
        inicio = null;
        N=0;
    }

//     comprobar invariantes internas
    public boolean revisar() {
        if (N == 0) {
            if (inicio != null) return false;
        }
        else if (N == 1) {
            if (inicio == null)      return false;
            if (inicio.prox != null) return false;
            if (inicio.ante != null) return false;
        }
        else {
            if (inicio.prox == null) return false;
        }

//         revisar consistencia interna de variable N
        int numeroDeNodos = 0;
        for (Nodo x = inicio; x != null; x = x.prox) {
            numeroDeNodos++;
        }
        if (numeroDeNodos != N) return false;

        return true;
    }
}
