/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author USER
 */
public  class ArbolBinarioBusqueda<K extends Comparable <K>,V> implements IArbolBusqueda<K, V> {

    protected NodoBinario<K,V> raiz;
    
    @Override
    public void vaciar() {
        this.raiz = (NodoBinario<K, V>)NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    public void insertar(K claveInsertar, V valorAInsertar) {
        if(claveInsertar == null){
            throw new IllegalArgumentException("Clave no puede ser Nula");
        }
        
        if(valorAInsertar == null){
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        
        if(this.esArbolVacio()){
            this.raiz = new NodoBinario<>(claveInsertar,valorAInsertar);
            return;
        }
        
        NodoBinario<K,V> nodoActual = this.raiz; //Puntero
        NodoBinario<K,V> nodoAnterior = (NodoBinario<K,V>)NodoBinario.nodoVacio(); // NOs retorna Null
        
        while(!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            nodoAnterior =  nodoActual;
            if(claveInsertar.compareTo(claveActual)< 0 ){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else if (claveInsertar.compareTo(claveActual)> 0){
                nodoActual = nodoActual.getHijoDerecho();
            }else { //La clave existe, entonces reemplazar su valor
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
       
        //la clave, entonces debo crear un nodo, con la clave y valor a insertar
        //y el nodoAnterior es el padre de ese nuevo nodo
        NodoBinario<K,V>  nuevoNodo = new NodoBinario<>(claveInsertar,valorAInsertar);
        K claveDelPadre = nodoAnterior.getClave();
        if(claveInsertar.compareTo(claveDelPadre)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public boolean contiene(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new ArrayList<>();
        if (!this.esArbolVacio()) {
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            NodoBinario<K, V> nodoActual = this.raiz;
            meterEnPilaParaPostOrden(nodoActual, pilaDeNodos);
            while (!pilaDeNodos.isEmpty()) {
                nodoActual = pilaDeNodos.pop();
                //visita del nodo. En este caso estoy agragando la clave a la lista
                recorrido.add(nodoActual.getClave());

                if (!pilaDeNodos.isEmpty()) {
                    NodoBinario<K, V> nodoDelTope = pilaDeNodos.peek();
                    if (!nodoDelTope.esVacioHijoDerecho()
                            && nodoDelTope.getHijoDerecho() != nodoActual) {
                        meterEnPilaParaPostOrden(nodoDelTope.getHijoDerecho(), pilaDeNodos);
                    }
                }
            }
        }
        return recorrido;
    }

    //8.1
    private void meterEnPilaParaPostOrden(NodoBinario<K, V> nodoActual, Stack<NodoBinario<K, V>> pilaDeNodos) {
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            pilaDeNodos.push(nodoActual);
            if (!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                nodoActual = nodoActual.getHijoDerecho();

            }
        }
    }

    @Override
    public List<K> recorridoPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarRecursivo(K clave, V valor) {
        this.raiz = insertarRecursivoMask(this.raiz,clave,valor);
    }
    
    private NodoBinario<K,V> insertarRecursivoMask(NodoBinario<K,V> nodoRaiz, K nuevoClave,V nuevoValor){
        if(nodoRaiz == null){
             NodoBinario<K,V>  nuevoNodo = new NodoBinario<>(nuevoClave,nuevoValor);
             this.raiz = nuevoNodo;
             return raiz;
        }else{
            if(nodoRaiz.getClave().compareTo(nuevoClave) > 0){
                nodoRaiz.setHijoIzquierdo( insertarRecursivoMask(nodoRaiz.getHijoIzquierdo(),nuevoClave,nuevoValor));
            }else if(nodoRaiz.getClave().compareTo(nuevoClave) == 0){
                nodoRaiz.setValor(nuevoValor);
            }else{
                 nodoRaiz.setHijoDerecho(insertarRecursivoMask(nodoRaiz.getHijoDerecho(),nuevoClave,nuevoValor));
            }
            return nodoRaiz;
        }
        
    }

    @Override
    public int cantidadNodos() {
        return cantidadNodosMask(this.raiz);
    }
    
    private int cantidadNodosMask(NodoBinario<K,V> nodoRaiz){
        if(nodoRaiz == null){
            return 0;
        }
        if(nodoRaiz.esHoja()){
            return 1;
        }
        int i = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        int d = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        return i + d + 1;
    }

    @Override
    public int cantidadHojas() {
        return cantidadHojasMask(this.raiz);
    }
    
    private int cantidadHojasMask(NodoBinario<K,V> nodoRaiz){
        //1er Caso Si mi arbol es Bacio
        if(nodoRaiz == null){
            return 0;
        }
        
        //2do Caso Base 
        if(nodoRaiz.esHoja()){
            return 1;
        }
        //Caso General
        int i = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        int d = cantidadNodosMask(nodoRaiz.getHijoIzquierdo());
        return i + d;
         
    }
    
    

    @Override
    public boolean verificarExiste(K valorX) { //ValorX = el valor Numerico que buscamos
        return verificarExisteMask(this.raiz, valorX);
    }
    
    private boolean verificarExisteMask(NodoBinario<K,V> nodoRaiz, K valorX){
        //1er Caso base
        if(nodoRaiz == null){
            return false;
        }
        
        if(nodoRaiz.getClave() == valorX){
            return true;
        }
        if(nodoRaiz.getClave().compareTo(valorX)> 0){
            return verificarExisteMask(nodoRaiz.getHijoIzquierdo(),valorX);
        }else{
            return verificarExisteMask(nodoRaiz.getHijoDerecho(), valorX);
        }
    }
    
    //Eliminar 
    // 3 Casoss 

    @Override
    public int contarNumerosPares() {
        return contarNumerosParesRecursivo(this.raiz);
    }
    
    private int contarNumerosParesRecursivo(NodoBinario<K,V> raizAuxiliar){
        //primer caso base (Arbol vacio)
        if(raizAuxiliar == null){
            return 0;
        }
        //2do Caso Base
        if(raizAuxiliar.esHoja()){
            int valor = (Integer)raizAuxiliar.getClave();
            if( valor % 2 == 0 ){
               return 1; 
            }else{ //Tomar en consideracion
                return 0;
            }
        }
        
        //Caso General
        int cantidadHijoI = contarNumerosParesRecursivo(raizAuxiliar.getHijoIzquierdo()); // 2
        int cantidadHijoD = contarNumerosParesRecursivo(raizAuxiliar.getHijoDerecho());  // 1 
        
        int valorPadre = (Integer)raizAuxiliar.getClave();
        if(valorPadre %2 == 0){
            return cantidadHijoI + cantidadHijoD + 1;
        }else{
            return cantidadHijoI + cantidadHijoD;
        }
        
    }

    @Override
    public int contarNumeroImpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoInOrdenR() {
        recorridoInOrdenRecursivo(this.raiz);
    }
    
    private void recorridoInOrdenRecursivo(NodoBinario<K,V> raizAuxiliar){
        //Caso Base
        if(raizAuxiliar == null){
            return;
        }
        recorridoInOrdenRecursivo(raizAuxiliar.getHijoIzquierdo());
        System.out.print(raizAuxiliar.getClave() + " " );
        recorridoInOrdenRecursivo(raizAuxiliar.getHijoDerecho());
    }
    

    @Override
    public void recorridoPreOrdenR() {
        recorridoPreOrdenRecursivo(this.raiz);
    }
    
    private void recorridoPreOrdenRecursivo(NodoBinario<K,V> raizAuxiliar){
        if(raizAuxiliar == null){
            return;
        }
        System.out.print(raizAuxiliar.getClave() + " ");
        recorridoPreOrdenRecursivo(raizAuxiliar.getHijoIzquierdo());
        recorridoPreOrdenRecursivo(raizAuxiliar.getHijoDerecho());
    }
    
    

    @Override
    public void recorridoPostOrdenR() {
        recorridoPostOrdenRecursivo(this.raiz);
    }
    
    private void recorridoPostOrdenRecursivo(NodoBinario<K,V> raizAuxiliar){
        if(raizAuxiliar == null){
            return;
        }
        recorridoPostOrdenRecursivo(raizAuxiliar.getHijoIzquierdo());
        recorridoPostOrdenRecursivo(raizAuxiliar.getHijoDerecho());
        System.out.print(raizAuxiliar.getClave() + " ");
    }

    @Override
    public int obtenerAlturaArbol() {
        return obtenerAlturaRecursivo(this.raiz);
    }
    
    private int obtenerAlturaRecursivo(NodoBinario<K,V> raizAuxiliar){
        //1er Caso BAse si mi arbol esta vacio
        if(raizAuxiliar == null){
            return 0;
        }
        //2do Caso base si mi arbol tiene 1 Nodo
        if(raizAuxiliar.esHoja()){
            return 1;
        }
        //Caso General (Mas de 1 Nodo)
        int hijoIzquierdo = obtenerAlturaRecursivo(raizAuxiliar.getHijoIzquierdo());
        int hijoDerecho = obtenerAlturaRecursivo(raizAuxiliar.getHijoDerecho());
        if(hijoIzquierdo > hijoDerecho){
            return hijoIzquierdo + 1;
        }else{
            return hijoDerecho + 1;
        }
        
    }

    @Override
    public int obtenerCantidadNodosIncompletos() {
        return obtenerCantidadNodosIncompletosRecursivo(this.raiz);
        
    }
    
    private int obtenerCantidadNodosIncompletosRecursivo(NodoBinario<K,V> raizAuxiliar){
        if(raizAuxiliar == null){
            return 0;
        }
        if(raizAuxiliar.esHoja()){
            return 0;
        }
        int i = obtenerCantidadNodosIncompletosRecursivo(raizAuxiliar.getHijoIzquierdo()); // 2
        int d = obtenerCantidadNodosIncompletosRecursivo(raizAuxiliar.getHijoDerecho()); // 1
//        for (int j = 0; j < 10; j++) { desde el primer hijo hasta el final del Hijo
//            
//        }
        if(raizAuxiliar.cantidadHijo() == 1){
            return i +d +1;
        }else{
            return i + d;
        }
        
    }

    @Override
    public void eliminarDatoXDeUnArbol(int valorX) {
        this.raiz = eliminarDatoXDeUnArbolRecursivo(this.raiz, valorX);
    }
    
    private NodoBinario<K,V> eliminarDatoXDeUnArbolRecursivo(NodoBinario<K,V> raizAuxiliar,int valorX){
        //en el caso que sea vacio
        if(raizAuxiliar == null){ 
            return null;
        }
        //en el caso que tenga 1 solo Nodo
        int ClaveRaiz = (Integer)raizAuxiliar.getClave();
        if(ClaveRaiz == valorX){
            return eliminarNodo(raizAuxiliar);
        }
        
        if(valorX < ClaveRaiz){
            NodoBinario<K,V> nuevoSubArbolIzquierdo =  eliminarDatoXDeUnArbolRecursivo(raizAuxiliar.getHijoIzquierdo(),valorX);
            raizAuxiliar.setHijoIzquierdo(nuevoSubArbolIzquierdo);
        }else{
            NodoBinario<K,V> nuevoSubArbolDerecho = eliminarDatoXDeUnArbolRecursivo(raizAuxiliar.getHijoDerecho(), valorX);
            raizAuxiliar.setHijoDerecho(nuevoSubArbolDerecho );
        }
        return raizAuxiliar;
    }

    @Override
    public NodoBinario<K,V> eliminarNodo(NodoBinario<K, V> punteroNodo) {
        //Caso 0
        if(punteroNodo.getHijoIzquierdo() == null && punteroNodo.getHijoDerecho() == null){
            return null;
        }
        
        //Caso 1
        //En el Caso que de existe solo hijo Derecho
        if(punteroNodo.getHijoIzquierdo() == null){
            return punteroNodo.getHijoDerecho();
        }
        if(punteroNodo.getHijoDerecho() == null){
            return punteroNodo.getHijoIzquierdo();
        }
        
        //Caso 2
        NodoBinario<K,V> nodoSucesor = buscarSiguienteSucesor(punteroNodo.getHijoDerecho());
        punteroNodo.setClave(nodoSucesor.getClave());
        NodoBinario<K,V> nuevoSubArbol = eliminarDatoXDeUnArbolRecursivo(punteroNodo.getHijoDerecho(),(Integer)nodoSucesor.getClave());
        punteroNodo.setHijoDerecho(nuevoSubArbol);
        return punteroNodo;
    }

    @Override
    public NodoBinario<K, V> buscarSiguienteSucesor(NodoBinario<K, V> nodo) {
        NodoBinario<K,V> sucesor = nodo;  //Codigo actualizado para evitar bucle infinito
        while(sucesor.getHijoIzquierdo() != null){
//            NodoBinario<K,V> nuevaRutaIzquierda = nodo.getHijoIzquierdo();
            sucesor = sucesor.getHijoIzquierdo(); //Codigo Actualizado para evitar bucle infinito
//            nodo.setHijoIzquierdo(nodo);
        }
        return sucesor; //Codigo actualizado para evitar bucle infinito
    }
}
