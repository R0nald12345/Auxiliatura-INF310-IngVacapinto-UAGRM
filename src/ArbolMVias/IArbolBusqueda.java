/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IArbolBusqueda<K extends Comparable<K>, V> {
    void vaciar();
    boolean esArbolVacio();
    int size(); //cantidad
    int altura();
    int nivel();
    K minimo();
    K maximo();
    void insertar(K clave, V valor);
    V eliminar(K clave);
    boolean contiene(K clave);
    V buscar(K clave);
    List<K> recorridoEnInOrden();
    List<K> recorridoPreOrden();
    List<K> recorridoPostOrden();
    List<K> recorridoPorNiveles();
    int verificarExiste(NodoMVias<K,V> nodoActual, K claveABuscar);
    public boolean esClaveVacia(int posicion);
    int sumarDatosDelNodo();
    int contarCantidadNumeroPar();
    void recorridoPostOrdenR();
    boolean verificarExiste(int dato);
    int getCantidadClaveNoVaciaPorNivel(int n);
}