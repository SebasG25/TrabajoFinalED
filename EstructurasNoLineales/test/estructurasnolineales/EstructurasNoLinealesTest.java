/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niwdeyen
 */

//NO TOCARR

public class EstructurasNoLinealesTest {

    //objetos para capturar todo aquello de System.out
    PrintStream sysOut;
    ByteArrayOutputStream salida = new ByteArrayOutputStream();

    //Árbol de pruebas
    BinarySearchTree test;

    public EstructurasNoLinealesTest() {
        //configuración para capturar la salida de datos
        sysOut = System.out;
        System.setOut(new PrintStream(salida));
        //Instanciación del árbol
        test = new BinarySearchTree(10);
        //datos de prueba que se pueden usar en https://visualgo.net/en/bst
        //10,5,3,8,20,7,18,25,23,30,21,24        
        test.Add(5);
        test.Add(3);
        test.Add(8);
        test.Add(20);
        test.Add(7);
        test.Add(18);
        test.Add(25);
        test.Add(23);
        test.Add(30);
        test.Add(21);
        test.Add(24);

    }

    @Test
    public void testInorden() {
        //Reiniciar la consola
        System.out.flush();
        //llamar al método
        test.InOrden();
        //validar la salida
        assertEquals("3 5 7 8 10 18 20 21 23 24 25 30 ", salida.toString());
    }

    @Test
    public void testPostorden() {
        //Reiniciar la consola
        System.out.flush();
        //llamar al método
        test.PostOrden();
        //validar la salida
        assertEquals("3 7 8 5 18 21 24 23 30 25 20 10 ", salida.toString());
    }

    @Test
    public void testPreorden() {
        //Reiniciar la consola
        System.out.flush();
        //llamar al método
        test.PreOrden();
        //validar la salida
        assertEquals("10 5 3 8 7 20 18 25 23 21 24 30 ", salida.toString());
    }

    @Test
    public void testCountNodes() {
        //comparar el retorno del método con el valor esperado
        assertEquals(12, test.CountNodes());
    }

    @Test
    public void testCountLeaves() {
        //comparar el retorno del método con el valor esperado
        assertEquals(6, test.CountLeaves());
    }

    @Test
    public void testDeleteOne() {
        //Reiniciar la consola
        System.out.flush();
        //borrar
        test.Delete(20);
        //mostrar el resultado
        test.InOrden();
        //validar la salida
        assertEquals("3 5 7 8 10 18 21 23 24 25 30 ", salida.toString());
    }
    
    @Test
    public void testDeleteOneByOne() {
        //Reiniciar la consola
        System.out.flush();
        //borrar uno a uno varios nodos
        test.Delete(5);
        test.Delete(3);
        test.Delete(20);
        test.Delete(25);
        test.Delete(30);
        test.Delete(8);
        //mostrar el resultado
        test.InOrden();
        //validar la salida
        assertEquals("7 10 18 21 23 24 ", salida.toString());
    }
    
    @Test
    public void testDeleteRoot() {
        //Reiniciar la consola
        System.out.flush();
        //nuevo árbol de prueba
        BinarySearchTree testDeleteRoot = new BinarySearchTree(55);
        testDeleteRoot.Add(99);
        //borrar
        testDeleteRoot.Delete(55);
        //mostrar el resultado
        testDeleteRoot.InOrden();
        //validar la salida
        assertEquals("99 ", salida.toString());
    }
    
    @Test
    public void testLastLevel() {
        //comparar el retorno del método con el valor esperado
        //tener en cuenta que se han eliminado nodos del árbol de pruebas
        System.out.flush();
        test.LastLevel();
        assertEquals("21 24 ", salida.toString());
    }

    @Test
    public void testLevelOrder() {
        //Reiniciar la consola
        System.out.flush();
        test.Delete(5);
        test.Delete(3);
        test.Delete(20);
        test.Delete(25);
        test.Delete(30);
        test.Delete(8);
        //llamar al método
        test.LevelOrder();
        //validar la salida
        assertEquals("10\n7 21\n18\n23 24\n", salida.toString());
    }
}
