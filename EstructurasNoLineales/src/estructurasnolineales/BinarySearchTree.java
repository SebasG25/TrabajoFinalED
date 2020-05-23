/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    public BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private int maxLevel;
    private int contNodes;
    private int contLeaves;
    private String levelOrder;

    public BinarySearchTree() {
        root = null;
        contNodes=0;
        contLeaves=0;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data, 0);
        contNodes=1;
        contLeaves = 1;
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    
    public void PostOrden(){
        PostOrden(root);
    }
    
    private void PostOrden(BinaryNode currentRoot) {
        //(izquierda, derecha, raiz)
        //...
        if(currentRoot != null){
            PostOrden(currentRoot.getLeft());
            PostOrden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden(){
        PreOrden(root);
    }
    
    private void PreOrden(BinaryNode currentRoot) {
        //(raiz, izquierda, derecha)
        //...
        if(currentRoot != null){
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
            
        }
    }

    //Punto 4
    public int CountNodes(){
        return CountNodes(root);
    }
    
    private int CountNodes(BinaryNode currentRoot) {
        if (currentRoot != null) {
            CountNodes(currentRoot.getLeft());
            if(!currentRoot.equals(root)){
                contNodes++;
            }
            CountNodes(currentRoot.getRight());
        }
        return getTotalNodes();
    }

    //Punto 5
    public int CountLeaves(){
        return CountLeaves(root);
    }
    
    private int CountLeaves(BinaryNode currentRoot) {
        //...
        if (currentRoot != null) {
            CountLeaves(currentRoot.getLeft());
            if(!currentRoot.isLeaf() && currentRoot.equals(root)){
                contLeaves--;
            }else if(currentRoot.isLeaf() && !currentRoot.equals(root)){
                contLeaves++;
            }
            CountLeaves(currentRoot.getRight());
        }
        return contLeaves;
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);
            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data, currentRoot.getLevel()+1));
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data, currentRoot.getLevel()+1));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Arreglar el método cuando solo haya un nodo
    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {
        BinaryNode node = Search(data);
        if(node != null){
            if(node == this.root && node.isLeaf()) {
                root = null;
            }
            if(node.isLeaf()) {
                if (position) {
                    father.setRight(null);
                }else{
                    father.setLeft(null);
                }
            }else if(node.hasOneChild()) {
                if (node.isChildPosition()) {
                
                    if(root == node){
                        BinaryNode minimum = getMinor(node.getRight());
                        Delete(minimum.getData());
                        node.setData(minimum.getData());
                        minimum.setLevel(node.getLevel());
                    }else if(position){
                        father.setRight(node.getRight());
                    }else{
                        father.setLeft(node.getRight());
                    }
                    node.setRight(null);

                }else{
                    if(root == node){
                        root=node.getLeft();
                        node.setLeft(null);
                    }else if(position){
                        father.setRight(node.getLeft());
                    }else{
                        father.setLeft(node.getLeft());
                    }
                    node.setRight(null);

                }
            }else{
                BinaryNode minimum = getMinor(node.getRight());
                Delete(minimum.getData());
                node.setData(minimum.getData());
                minimum.setLevel(node.getLevel());
            }
        }
    }

    //Punto 7
    public void LastLevel(){
        LastLevel(root);
    }
    
    public void LastLevel(BinaryNode currentRoot) {
        //...
        if(currentRoot != null){
            LastLevel(currentRoot.getLeft());
            if(currentRoot.getLevel() == getMaxLevel()){
                System.out.print(currentRoot.getData() + " ");
            }
            LastLevel(currentRoot.getRight());
        }
    }

    //Punto 8
    public void LevelOrder(){
        LevelOrder(root, 0);
    }
    
    private void LevelOrder(BinaryNode currentRoot, int currentLevel){
        //...
        /* 
        Para mostrar los datos se recomienda usar:
            System.out.print(x.getData()+" ");
        donde x representa un nodo del árbol

        Para generar un salto de linea se recomienda usar:
            System.out.print("\n");
         */
//        System.out.println(currentLevel);
        for(int i = 0; i <= getMaxLevel(); i++){
            System.out.println(SearchLevel(i));
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
    
    public int getMaxLevel(){
        getMaxLevel(root);
        return maxLevel;
    }
    
    private void getMaxLevel(BinaryNode currentRoot){
        if(currentRoot != null){
            getMaxLevel(currentRoot.getLeft());
            if(currentRoot.getLevel() > maxLevel){
                maxLevel = currentRoot.getLevel();
            }
            getMaxLevel(currentRoot.getRight());
        }
    }
    
    public String SearchLevel(int level) {
        return SearchLevel(level, root);
    }
    
    private String SearchLevel(int level, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return "";
        }else  if (level == currentRoot.getLevel()) {
            return currentRoot.getData() + "";
        }
        else{
            return (SearchLevel(level, currentRoot.getLeft()) + " " + SearchLevel(level, currentRoot.getRight())).trim();
        }
    }

    /**
     * @return the contNodos
     */
    public int getTotalNodes() {
        return contNodes;
    }

    /**
     * @param contNodos the contNodos to set
     */
    public void setContNodes(int contNodes) {
        this.contNodes = contNodes;
    }

    /**
     * @return the contLeaves
     */
    public int getContLeaves() {
        return contLeaves;
    }
}
