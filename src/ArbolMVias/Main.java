/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;


/**
 *
 * @author USER
 */



public class Main {
    public static void main(String[] args) {
        ArbolMViasBusqueda<Integer, String> arbolPrueba = new ArbolMViasBusqueda<>();
//        arbolPrueba.insertar(50, "Azul");
//        arbolPrueba.insertar(78, "Naranja");
//        arbolPrueba.insertar(74, "Zapato");
//        arbolPrueba.insertar(30, "Jeans");
//        arbolPrueba.insertar(44, "Amarillo");
//        arbolPrueba.insertar(20, "Negro");
//        arbolPrueba.insertar(25, "Cafe");
//        arbolPrueba.insertar(24, "Camisa");
//        arbolPrueba.insertar(23, "Mesa");
//        arbolPrueba.insertar(28, "Tv");
//        arbolPrueba.insertar(74, "Tv");
//        arbolPrueba.insertar(120, "Banana");
//        arbolPrueba.insertar(35, "Arroz");
//        arbolPrueba.insertar(111, "Blusa");
//        arbolPrueba.insertar(90, "Zapato");
//        arbolPrueba.insertar(81, "Portatil");
//        arbolPrueba.insertar(71, "Llaves");
//        arbolPrueba.insertar(100, "Mouse");
//        arbolPrueba.insertar(89, "Cable");
//        arbolPrueba.insertar(51, "Termico");

        arbolPrueba.insertar(80, "Arroz");
        arbolPrueba.insertar(90, "Blusa");
        arbolPrueba.insertar(70, "Zapato");
        arbolPrueba.insertar(78, "Portatil");
        arbolPrueba.insertar(85, "Llaves");
        arbolPrueba.insertar(100, "Mouse");
//        arbolPrueba.insertar(89, "Cable");
//        arbolPrueba.insertar(51, "Termico");
        

        System.out.println(arbolPrueba);
//        System.out.println(arbolPrueba.recorridoPorNiveles());
        System.out.println(arbolPrueba.recorridoEnInOrden());
        System.out.println("Altura de mi Arbol: " + arbolPrueba.altura());
        System.out.println("Suma de todos los Datos: " + arbolPrueba.sumarDatosDelNodo());
        System.out.println("Verificar Existe: " + arbolPrueba.verificarExiste(1000));
        System.out.println("Cantidad de Claves vacias por nivel: " + arbolPrueba.getCantidadClaveNoVaciaPorNivel(2));
//        System.out.println("Recorido por Niveles");
//        System.out.println(arbolPrueba.recorridoPorNiveles());
        
    }
}
