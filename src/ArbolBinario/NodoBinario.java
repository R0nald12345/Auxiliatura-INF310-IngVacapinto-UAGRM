/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author USER
 */
public class NodoBinario<K,V> {
    //Atributos

    private K clave;
    private V valor;
    private NodoBinario<K, V> hijoIzquierdo;
    private NodoBinario<K, V> hijoDerecho;

    //Constructor
    public NodoBinario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public NodoBinario<K, V> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario<K, V> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esVacioHijoIzquierdo() {
        return NodoBinario.esNodoVacio(this.hijoIzquierdo);
//        return this.hijoIzquierdo == null;
    }

    public boolean esVacioHijoDerecho() {
        return NodoBinario.esNodoVacio(this.hijoDerecho);
    }

    public int cantidadHijo() {
        if (this.hijoIzquierdo == null || this.hijoDerecho == null) {
            return 1;
        }
        if (this.hijoIzquierdo == null && this.hijoDerecho == null) {
            return 0;
        }
        return 2;
    }

    public boolean esHoja() {
        return this.esVacioHijoIzquierdo() && this.esVacioHijoDerecho();
//          return this.hijoIzquierdo == null && this.hijoDerecho ==null;
    }

    public boolean esNodoCompleto() {
        return !this.esVacioHijoIzquierdo() && !this.esVacioHijoDerecho();
    }

    public static boolean esNodoVacio(NodoBinario nodo) {
        return nodo == NodoBinario.nodoVacio();
    }

    public static NodoBinario<?, ?> nodoVacio() {
        return null;
    }
}
