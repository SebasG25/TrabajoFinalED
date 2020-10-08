/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {

    static JFrame ventana;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BinarySearchTree test = new BinarySearchTree(); //MODELO
        Lienzo objLienzo = new Lienzo(); //VISTA
        Controlador objControlador = new Controlador(objLienzo, test); //CONTROLADOR
        
        objControlador.iniciar();
        
        ventana = new JFrame();
        ventana.getContentPane().add(objLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(1900, 1080);
        ventana.setVisible(true);
    }
    
    public JFrame getVentana(){
        return ventana;
    }
}
