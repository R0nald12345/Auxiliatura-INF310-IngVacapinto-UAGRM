/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author USER
 */
public class ExceptionOrdenInvalido extends Exception{
    
    public ExceptionOrdenInvalido(){
        super("Arbol con orden InValido");
    }
    
    public ExceptionOrdenInvalido(String message){
        super(message);
    }
}
