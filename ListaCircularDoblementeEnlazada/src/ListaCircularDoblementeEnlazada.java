
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaCircularDoblementeEnlazada<Tipo> implements Iterable<Tipo> {
    
    private int N;
    private Nodo inicio;
    private Nodo fin;
    
    private class Nodo{
        Tipo item;
        Nodo prox;
        Nodo ante;
    }
    
    public ListaCircularDoblementeEnlazada(){
        N = 0;
        inicio = null;
    }
    
    public boolean estaVacia(){
        return inicio == null;
    }
    
    public int tamanno(){
        return N;
    }
    
    public void insertarAlInicio(Tipo item){
        Nodo iniciopasado = inicio;     
        if(N == 0){
            inicio = fin = new Nodo();
            inicio.item=item;
            fin.prox=inicio;
            inicio.ante=fin;            
        }else{
            inicio = new Nodo();
            inicio.item = item;
            inicio.prox = iniciopasado;            
            inicio.ante = fin;
            iniciopasado.ante=inicio;
            fin.prox = inicio;       
            iniciopasado=inicio;
        }        
        N++;
    }
    
    public Tipo eliminarAlInicio(){
        if(estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Tipo item= inicio.item;
        if(N==1) inicio=fin=null;
        else{
            inicio=inicio.prox;
            inicio.ante=fin;
            fin.prox=inicio;            
        }
        N--;
        return item;        
    }
    
    public void insertarAlFinal(Tipo item){
        Nodo finpasado=fin;
        if(N==0){
            inicio=fin=new Nodo();
            fin.item=item;
            fin.prox=inicio;
            inicio.ante=fin;
            finpasado=fin;
        }else{
            fin=new Nodo();
            fin.item=item;
            fin.ante=finpasado;
            fin.prox=inicio;
            finpasado.prox=fin;
            inicio.ante=fin;
            finpasado=fin;            
        }
        N++;        
    }
    
    public Tipo eliminarAlFinal(){
        if(estaVacia()) throw new NoSuchElementException("Lista Vacía");
        Tipo item=fin.item;
        if(N==1) inicio=fin=null;
        else{
            fin=fin.ante;
            fin.prox=inicio;
            inicio.ante=fin;
        }
        N--;
        return item;       
    }
    
    
    
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
    
    public boolean revisar() {
        if (N == 0) {
            if (inicio != null) return false;
            if (fin != null) return false;
        }
        else if (N == 1) {
            if (inicio == null) return false;
            if (fin == null) return false;
            if (inicio.ante != fin) return false;
            if (fin.prox != inicio) return false;
        }
        else {
            if (inicio.prox == null) return false;
            if (inicio.ante != fin) return false;
            if (fin.prox != inicio) return false;
            if (fin.ante ==null) return false;
        }

        Nodo x;
        int numeroDeNodos = 0;        
        for (x = inicio; x != fin ; x = x.prox) {
            numeroDeNodos++;            
        }
       
        if(x!=null && x == fin) numeroDeNodos++;
                
        if (numeroDeNodos != N) return false;

        return true;
    }
    
    
    
    
    
    
}
