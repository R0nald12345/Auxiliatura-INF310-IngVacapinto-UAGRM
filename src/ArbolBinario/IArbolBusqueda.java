/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;


import java.util.List;

/**
 *
 * @author USER
 */
public interface IArbolBusqueda<K extends Comparable<K>,V> {
    
    void vaciar();
    boolean esArbolVacio();
    void insertar(K clave, V valor);
    
    void insertarRecursivo(K clave, V valor);
    
    int cantidadNodos();
    int cantidadHojas();
    boolean verificarExiste(K valorX);
    
    boolean contiene(K clave);
    List<K> recorridoPreOrden();
    List<K> recorridoEnPostOrden();
    List<K> recorridoPorNiveles();
    
    int contarNumerosPares();
    int contarNumeroImpar();
    void recorridoInOrdenR();
    void recorridoPreOrdenR();
    void recorridoPostOrdenR();
    int obtenerAlturaArbol();
    int obtenerCantidadNodosIncompletos();
    void eliminarDatoXDeUnArbol(int valorX);
    NodoBinario<K,V> eliminarNodo(NodoBinario<K,V> punteroNodo);
    NodoBinario<K, V> buscarSiguienteSucesor(NodoBinario<K,V> nodo);
}