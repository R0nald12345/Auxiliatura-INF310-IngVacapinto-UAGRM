/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USER
 */
public class NodoMVias<K, V> {

    private List<K> listaDeClaves;
    private List<V> listaDeValores;
    private List<NodoMVias<K, V>> listaDeHijos;

    public NodoMVias(int orden) {
        listaDeHijos = new LinkedList<>();
        listaDeValores = new LinkedList<>();
        listaDeClaves = new LinkedList<>();
        for (int i = 0; i < orden - 1; i++) {
            listaDeHijos.add(nodoVacio());
            listaDeClaves.add((K) datoVacio());
            listaDeValores.add((V) datoVacio());
        }
        listaDeHijos.add(nodoVacio());
    }

    public NodoMVias(int orden, K primerClave, V primerValor) {
        this(orden); //Manda a llamar al constructor
        this.listaDeClaves.set(0, primerClave);
        this.listaDeValores.set(0, primerValor);
    }

    public static NodoMVias nodoVacio() {
        return null;
    }

    public static Object datoVacio() {
        return null;
    }

    /**
     * Retorna la Clave de la posicion indicada por el parametro posicion
     * PreCondicion: El parametro posicion indica una posicion válida en el
     * arreglo de la lista de Claves
     */
    public K getClave(int posicion) {
        return this.listaDeClaves.get(posicion);
    }

    public void setClave(int posicion, K clave) {
        this.listaDeClaves.set(posicion, clave);
    }

    public V getValor(int posicion) {
        return this.listaDeValores.get(posicion);
    }

    public void setValor(int posicion, V valor) {
        this.listaDeValores.set(posicion, valor);
    }

    public NodoMVias<K, V> getHijo(int posicion) {
        return this.listaDeHijos.get(posicion);
    }

    public void setHijo(int posicion, NodoMVias<K, V> nodo) {
        this.listaDeHijos.set(posicion, nodo);
    }

    public static boolean esNodoVacio(NodoMVias nodo) {
        return nodo == nodoVacio();
    }

    public boolean esClaveVacia(int posicion) {
        return this.listaDeClaves.get(posicion) == datoVacio();
    }

    public boolean esHijoVacio(int posicion) {
        return this.listaDeHijos.get(posicion) == nodoVacio();
    }

    public boolean esHoja() {
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean estanClaveLlenas() {
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                return false;
            }
        }
        return true;
    }

    public int cantidadDeHijosNoVacios() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeHijos.size(); i++) {
            if (!this.esHijoVacio(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int cantidadDeClavesNoVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (!this.esClaveVacia(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
     public int cantidadDeClavesVacias() {
        int cantidad = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (this.esClaveVacia(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int sumarDatosNodo() {
        int contador = 0;
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if (listaDeClaves.get(i) == null) {
                continue;
            } else {
                contador += (Integer) listaDeClaves.get(i);
            }
        }
        return contador;
    }
    
    public boolean verificarExisteDatoInNodo(int dato){
        for (int i = 0; i < this.listaDeClaves.size(); i++) {
            if(this.listaDeClaves.get(i) == null){
                continue;
            }else{
                if((Integer)this.listaDeClaves.get(i) == dato){
                    return true;
                }
            }
        }
        return false;
    }

}
