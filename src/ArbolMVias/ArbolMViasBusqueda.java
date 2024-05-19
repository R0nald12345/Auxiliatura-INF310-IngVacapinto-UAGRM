/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import excepciones.ExceptionOrdenInvalido;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author USER
 */
public class ArbolMViasBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

    protected NodoMVias<K, V> raiz;
    protected int orden;
    protected int POSICION_INVALIDA = -1;

    public ArbolMViasBusqueda() {
        this.orden = 3;
    }

    public ArbolMViasBusqueda(int orden) throws ExceptionOrdenInvalido {
        if (orden < 3) {
            throw new ExceptionOrdenInvalido();
        }
        this.orden = orden;
    }

    @Override
    public void vaciar() {
        this.raiz = NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public int altura() {
////        return alturaRecursivo(this.raiz);
//    }
//    
//    private int alturaRecursivo(NodoMVias<K,V> raizAux){
////        if(raizAux == null){
////            return 0;
////        }
////        if(es){
////            
////        }
//    }
//    private boolean esHoja(NodoMVias<K,V> raizAux){
//        for (int i = 0; i < raizAux.cantidadDeHijosNoVacios(); i++) {
//            
//        }
//    }
    @Override
    public int nivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public K minimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public K maximo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (this.esArbolVacio()) { //en Caso del Arbol Vacio
            this.raiz = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
            return;
        }
        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionClaveExistente = this.getPosicionDeClave(nodoActual, claveAInsertar);
            if (posicionClaveExistente != POSICION_INVALIDA) {
                nodoActual.setValor(posicionClaveExistente, valorAInsertar);
                return; //nodoActual = NodoMVias.nodoVacio();
            } else if (nodoActual.esHoja()) {
                if (nodoActual.estanClaveLlenas()) {
                    int posicionPorDondeBajar = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                } else {
                    this.insertarClaveYValorEnNodo(nodoActual, claveAInsertar, valorAInsertar);
                }
                nodoActual = NodoMVias.nodoVacio(); //para romper el bucle
            } else {
                int posicionPorDondeBajar = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
                if (nodoActual.esHijoVacio(posicionPorDondeBajar)) {
                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
                    nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                    nodoActual = NodoMVias.nodoVacio();
                } else {
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }

        }
//        if (claveAInsertar == (K) NodoMVias.datoVacio()) {
//            throw new NullPointerException("No se permiten insertar claves nulas");
//        }
//
//        if (valorAInsertar == (V) NodoMVias.datoVacio()) {
//            throw new NullPointerException("No se permiten insertar valores nulos");
//        }
//
//        if (this.esArbolVacio()) {
//            this.raiz = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
//            return;
//        }
//
//        NodoMVias<K, V> nodoActual = this.raiz;
//        while (!NodoMVias.esNodoVacio(nodoActual)) {
//            int posicionDeClaveAInsertar = this.getPosicionDeClave(nodoActual, claveAInsertar);
//            if (posicionDeClaveAInsertar != this.POSICION_INVALIDA) {
//                nodoActual.setValor(posicionDeClaveAInsertar, valorAInsertar);
//                return;
//                //nodoActual = NodoMVias.nodoVacio();
//            }
//
//            if (nodoActual.esHoja()) {
//                if (nodoActual.estanClaveLlenas()) {
//                    NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
//                    int posicionDeEnlace = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
//                    nodoActual.setHijo(posicionDeEnlace, nuevoHijo);
//                } else {
//                    this.insertarClaveYValorEnNodo(nodoActual, claveAInsertar, valorAInsertar);
//                }
//                return;
//            }
//
//            int posicionPorDondeBajar = this.getPosicionPorDondeBajar(nodoActual, claveAInsertar);
//            if (nodoActual.esHijoVacio(posicionPorDondeBajar)) {
//                NodoMVias<K, V> nuevoHijo = new NodoMVias<>(this.orden, claveAInsertar, valorAInsertar);
//                nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
//                return;
//            }
//            nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
//        }//fin while
    }

    protected void insertarClaveYValorEnNodo(NodoMVias<K, V> nodoActual, K claveAInsertar, V valorAInsertar) {
        int posicionDondeInsertar = getPosicionDondeInsertar(nodoActual, claveAInsertar);
        int posicionActual = nodoActual.cantidadDeClavesNoVacias();
        while (posicionActual > posicionDondeInsertar) {
            K claveActual = nodoActual.getClave(posicionActual - 1);
            V valorActual = nodoActual.getValor(posicionActual - 1);
            nodoActual.setClave(posicionActual, claveActual);
            nodoActual.setValor(posicionActual, valorActual);
            posicionActual--;
        }
        nodoActual.setClave(posicionDondeInsertar, claveAInsertar);
        nodoActual.setValor(posicionDondeInsertar, valorAInsertar);
    }

    protected int getPosicionDondeInsertar(NodoMVias<K, V> nodoActual, K claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    protected int getPosicionPorDondeBajar(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    @Override
    public V eliminar(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
//    @Override
//    public boolean contiene(K clave) {
//        return buscar(clave) != null;
//    }

//    @Override
//    public V buscar(K claveABuscar) {
//        NodoMVias<K,V> nodoActual = raiz;
//        while(){
//            
//        }
//                
//        return null;
//    }
    @Override
    public List<K> recorridoEnInOrden() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoEnInOrden(NodoMVias<K, V> nodoActual, List<K> recorrido) {
        //n == 0
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoEnInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);
    }

    @Override
    public List<K> recorridoPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPostOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<K> recorridoPorNiveles() {
////        List<K> recorrido = new ArrayList<>();
////        if (!this.esArbolVacio()) {
////            Queue<NodoMVias<K, V>> colaDeNodos = new LinkedList<>();
////            colaDeNodos.offer(this.raiz);
////            while (!colaDeNodos.isEmpty()) {
////                NodoMVias<K, V> nodoActual = colaDeNodos.poll();
////                for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
////                    recorrido.add(nodoActual.getClave(i));
////                    if (!nodoActual.esHijoVacio(i)) {
////                        colaDeNodos.offer(nodoActual.getHijo(i));
////                    }
////                }//fin for
////
////                if (!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())) {
////                    colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
////                }
////            }
////        }
////        return recorrido;
//
//        List<K> recorrido = new ArrayList<>();
//        if (this.esArbolVacio()) {
//            return recorrido;
//        }
//
//        Queue<NodoMVias<K, V>> colaNodos = new LinkedList<>();
//        colaNodos.offer(this.raiz);
//        while (!colaNodos.isEmpty()) {
//            NodoMVias<K, V> nodoActual = colaNodos.poll(); //saco
//            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
//                recorrido.add(nodoActual.getClave(i));
//                if (!nodoActual.esHijoVacio(i)) {
//                    colaNodos.offer(nodoActual.getHijo(i));
//                }
//            }//fin FOR
//            if (!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())) {
//                colaNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
//            }
//        }
//        return recorrido;
//    }
//    @Override
//    public List<K> recorridoPorNiveles() {
//        List<K> recorrido = new ArrayList<>();
//        int altura = altura();
//        for (int nivel = 0; nivel <= altura; nivel++) {
//            recorridoPorNivelesRecursivo(this.raiz, recorrido, nivel);
//        }
//        return recorrido;
//    }
//    private void recorridoPorNivelesRecursivo(NodoMVias<K, V> nodoActual, List<K> recorrido, int nivelActual) {
//        if (NodoMVias.esNodoVacio(nodoActual) || nivelActual < 0) {
//            return;
//        }
//
//        if (nivelActual == 0) {
//            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
//                recorrido.add(nodoActual.getClave(i));
//            }
//        } else {
//            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
//                recorridoPorNivelesRecursivo(nodoActual.getHijo(i), recorrido, nivelActual - 1);
//            }
//            recorridoPorNivelesRecursivo(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido, nivelActual - 1);
//        }
//    }
    public int verificarExiste(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeHijosNoVacios(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveActual.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    protected int getPosicionDeClave(NodoMVias<K, V> nodoActual, K claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            K claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    @Override
    public boolean contiene(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V buscar(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esClaveVacia(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return alturaRecursivo(this.raiz);
    }

    private int alturaRecursivo(NodoMVias<K, V> raizAuxiliar) {
        if (raizAuxiliar == null) {
            return 0;
        }
        if (raizAuxiliar.esHoja()) {
            return 1;
        }
        int may = 0;
        for (int i = 0; i < this.orden; i++) {
            int h = alturaRecursivo(raizAuxiliar.getHijo(i));
            if (h > may) {
                may = h;
            }
        }
        return may + 1;
    }

    @Override
    public List<K> recorridoPorNiveles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int sumarDatosDelNodo() {
        return sumarDatosRecursivo(this.raiz);
    }

    private int sumarDatosRecursivo(NodoMVias<K, V> raizAuxiliar) {
        //Verificar si esta vacio
        if(raizAuxiliar == null){
            return 0;
        }
        
        if(raizAuxiliar.esHoja()){            
            return raizAuxiliar.sumarDatosNodo();
        }
        
        //Recorre sus hijos
        int contador = 0;
        for (int i = 0; i < this.orden; i++) {
            int sumaDatosNodo = sumarDatosRecursivo(raizAuxiliar.getHijo(i));
            contador  += sumaDatosNodo;
        }
        return contador + raizAuxiliar.sumarDatosNodo();

    }

 
    @Override
    public int contarCantidadNumeroPar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorridoPostOrdenR() {
        recorridoPostOrdenRecursivo(this.raiz);
    }

    private void recorridoPostOrdenRecursivo(NodoMVias<K, V> nodoActual) {
        //Que es un Arbol
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }

        //En el Padre 
        for (int i = 0; i < nodoActual.cantidadDeHijosNoVacios(); i++) {
            recorridoPostOrdenRecursivo(nodoActual.getHijo(i));
        }
        
        //
        recorridoPostOrdenRecursivo(nodoActual.getHijo(nodoActual.cantidadDeHijosNoVacios()));
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            System.out.print(nodoActual.getClave(i) + " ");
        }
    }

    @Override
    public boolean verificarExiste(int dato) {
        return verificarExiteRecursivo(this.raiz, dato);
    }
    
    private boolean verificarExiteRecursivo(NodoMVias<K,V> raizAuxiliar, int dato){
        if(raizAuxiliar == null){
            return false;
        }
        if(raizAuxiliar.esHoja()){
            return raizAuxiliar.verificarExisteDatoInNodo(dato);
        }
        
        //Caso General
        boolean resultado = false;
        for (int i = 0; i < this.orden; i++) {
            resultado = verificarExiteRecursivo(raizAuxiliar.getHijo(i),dato);
        }
        
        //Verificar el Padre
        if(resultado == false){
            resultado = raizAuxiliar.verificarExisteDatoInNodo(dato);
        }
        
        return resultado;
    }

    /**
     * Este metodo me muestra la cantidad de claves no vacias por nivel,
     * en caso de que mi arbol es vacio, o si el usuario inserta un nivel fuera del rango
     * me retonara -1
     */
    public int getCantidadClaveNoVaciaPorNivel(int n ) {
        if(raiz == null){ //mi arbol es vacio
            return -1;
        }
        
        if(n<= altura()){
            int contador = 0; //Para contar las claves no vacias
            Queue<NodoMVias> cola = new LinkedList<>();
            cola.add(raiz);
            int nivel = 0;

            while(!cola.isEmpty()){
                int tamanio = cola.size();
                nivel++;
                for (int i = 0; i < tamanio; i++) {
                    NodoMVias nodoAux = cola.poll();
                    
                    
                    
                    if(nivel == n){
                        //se pone a contar las claves nulas
                        contador = contador + nodoAux.cantidadDeClavesVacias();
                    }
                    for (int j = 0; j < this.orden; j++) {
                        cola.add(nodoAux.getHijo(j));
                    }

                }
               if(nivel == n){
                   break;
               } 
            }
            return contador;
        }else{
            return -1;
        }
        
    }

    

}
