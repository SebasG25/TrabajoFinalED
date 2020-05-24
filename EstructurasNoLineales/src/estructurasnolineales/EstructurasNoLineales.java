/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        System.out.println(maxData.getDataHeap());
        maxData.ExtractMax();
        System.out.println(maxData.getDataHeap());

        BinarySearchTree test = new BinarySearchTree(10);
        try {
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
            System.out.print("Inorden: ");
            test.InOrden(); 
            System.out.println("");
            System.out.print("PreOrden: ");
            test.PreOrden();
            System.out.println("");
            System.out.print("PosOrden: ");
            test.PostOrden();
            System.out.println("");
            System.out.println("El total de nodos es: " + test.CountNodes());
            System.out.println("El total de hojas es: " + test.CountLeaves());
            System.out.print("Nodos en el último nivel: ");
            test.LastLevel();
            System.out.println("");
            System.out.println("Imprimir según el nivel: ");
            test.LevelOrder();
            System.out.println("");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");
        //System.out.println(pino.Search(88));
    }
}
