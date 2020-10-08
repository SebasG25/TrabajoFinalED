/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author Sebastian
 */
public class Controlador {
    private Lienzo objLienzo;
    private BinarySearchTree tree;
    
    public Controlador(Lienzo objLienzo, BinarySearchTree tree){
        this.objLienzo = objLienzo;
        this.tree = tree;
    }
    
    public void iniciar(){
        objLienzo.setBinarySearchTree(tree);
    }
}
