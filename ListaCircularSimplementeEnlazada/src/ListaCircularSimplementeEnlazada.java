import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaCircularSimplementeEnlazada<Tipo> implements Iterable<Tipo> {
    private int N;          // tamaño de la lista
    private Nodo inicio;     // inicio de la lista
    private Nodo fin;     // final de la lista

    private class Nodo {
        private Tipo item;
        private Nodo prox;
       
    }

    public ListaCircularSimplementeEnlazada() {
        inicio = null;
        fin = null;
        N = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int tamanno() {
        return N;
    }

    public void insertarAlInicio(Tipo item) {
        Nodo inicioAnterior = inicio;        
        if(N==0){
            inicio = fin = new Nodo();
        }
        else{
            inicio = new Nodo();            
        }
             
        inicio.item = item;
        inicio.prox = inicioAnterior;
        fin.prox = inicio;
        N++;        
    }

    public Tipo eliminarAlInicio() {
        if (estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Tipo item = inicio.item;        // guarda item a devolver
        if(N==1){
            inicio=fin = null;
        }
        else {
            inicio = inicio.prox;           // borra el primer nodo
            fin.prox = inicio;
        }
        N--;
        return item;                    // devuelve el item guardado
    }
    public void insertarAlFinal(Tipo item){
        Nodo finAnterior = fin;
        if(N==0){
            fin=inicio= new Nodo();
        }
        else{
            fin= new Nodo();
            finAnterior.prox = fin;
        }
        fin.item = item;
        fin.prox = inicio;
        
        N++;
    }
    public Tipo eliminarAlFinal() {
        if (estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Tipo borrado;
        if(N==1){
            borrado=inicio.item;
            inicio=fin=null;
        }
        else{
            Nodo penultimo=null;
            for(Nodo x=inicio;x!=fin;x=x.prox){
                penultimo=x;
            }
            borrado = fin.item;
            penultimo.prox=inicio;
            fin=penultimo;
        }
        N--;
        return borrado;
    }
    //Devuelve el primer item pero no lo elimina
    public Tipo primero() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return inicio.item;
    }
    
    public Tipo ultimo() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return fin.item;
    }

    //Devuelve una representación de cadena de esta lista
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
        private int contador = N;
        public boolean hasNext() {
            return (actual != null && contador>0);                     
        }
        
        public void remove(){ throw new UnsupportedOperationException();  }

        public Tipo next() {               
            if (!hasNext()) throw new NoSuchElementException();
            Tipo item = actual.item;
            actual = actual.prox; 
            contador--;
            return item;            
        }
    }


    // comprobar invariantes internas
    public boolean revisar() {
        if (N == 0) {
            if (inicio != null) return false;
            if (fin != null) return false;
        }
        else if (N == 1) {
            if (inicio == null) return false;
            if (fin == null) return false;
            if (inicio.prox != inicio) return false;
            if (fin.prox != inicio) return false;
        }
        else {
            if (inicio.prox == null) return false;            
            if (fin.prox != inicio) return false;
        }

//         revisar consistencia interna de variable N
        Nodo x;
        int numeroDeNodos = 0;        
        for (x = inicio; x != fin ; x = x.prox) {
            numeroDeNodos++;
            //El valor de esta variable queda en N-1 ya que a la siguiente iteracion x 
            //tomaria el valor de fin (ultimo nodo) por lo tanto no entraria al bucle y
            //no se contaria el ultimo nodo.
            //Para un único nodo tampoco se entraria al bucle y el contador no aumentaría.
        }
        //Aqui se resuelve el problema para un unico nodo y para el ultimo nodo.
        if(x!=null && x == fin) numeroDeNodos++;
                
        if (numeroDeNodos != N) return false;

        return true;
    }
}
