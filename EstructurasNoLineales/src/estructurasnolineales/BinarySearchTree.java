/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    private int maxLevel;
    private int contNodes;
    private int contLeaves;
    private String levelOrder;

    public BinarySearchTree() {
        root = null;
        contNodes = 0;
        contLeaves = 0;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data, 0);
        contNodes = 1;
        contLeaves = 1;
    }

    //Punto 1
    public void InOrden() {
        InOrden(getRoot());
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    public void PostOrden() {
        PostOrden(getRoot());
    }

    private void PostOrden(BinaryNode currentRoot) {
        //(izquierda, derecha, raiz)
        //...
        if (currentRoot != null) {
            PostOrden(currentRoot.getLeft());
            PostOrden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden() {
        PreOrden(getRoot());
    }

    private void PreOrden(BinaryNode currentRoot) {
        //(raiz, izquierda, derecha)
        //...
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());

        }
    }

    //Punto 4
    public int CountNodes() {
        return CountNodes(getRoot());
    }

    private int CountNodes(BinaryNode currentRoot) {
        if (currentRoot != null) {
            CountNodes(currentRoot.getLeft());
            if (!currentRoot.equals(root)) {
                contNodes++;
            }
            CountNodes(currentRoot.getRight());
        }
        return getTotalNodes();
    }

    //Punto 5
    public int CountLeaves() {
        return CountLeaves(getRoot());
    }

    private int CountLeaves(BinaryNode currentRoot) {
        //...
        if (currentRoot != null) {
            CountLeaves(currentRoot.getLeft());
            if (!currentRoot.isLeaf() && currentRoot.equals(getRoot())) {
                contLeaves--;
            } else if (currentRoot.isLeaf() && !currentRoot.equals(root)) {
                contLeaves++;
            }
            CountLeaves(currentRoot.getRight());
        }
        return contLeaves;
    }

    public void Add(int data) {
        if (getRoot() == null) {
            setRoot(new BinaryNode(data));
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar un dato repetido", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Add(data, getRoot());
            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data, currentRoot.getLevel() + 1));
            } else {
                Add(data, currentRoot.getLeft());
            }
        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data, currentRoot.getLevel() + 1));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, getRoot());
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
        if (getRoot() == null) {
            JOptionPane.showMessageDialog(null, "No existe un árbol", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Delete(data, getRoot());
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {
        BinaryNode node = Search(data);
        if (node != null) {
            if (node == this.getRoot() && node.isLeaf()) {
                setRoot(null);
            }
            if (node.isLeaf()) {
                if (position) {
                    father.setRight(null);
                } else {
                    father.setLeft(null);
                }
            } else if (node.hasOneChild()) {
                if (node.isChildPosition()) {

                    if (getRoot() == node) {
                        BinaryNode minimum = getMinor(node.getRight());
                        Delete(minimum.getData());
                        node.setData(minimum.getData());
                        minimum.setLevel(node.getLevel());
                    } else if (position) {
                        father.setRight(node.getRight());
                    } else {
                        father.setLeft(node.getRight());
                    }
                    node.setRight(null);

                } else {
                    if (getRoot() == node) {
                        setRoot(node.getLeft());
                        node.setLeft(null);
                    } else if (position) {
                        father.setRight(node.getLeft());
                    } else {
                        father.setLeft(node.getLeft());
                    }
                    node.setRight(null);

                }
            } else {
                BinaryNode minimum = getMinor(node.getRight());
                Delete(minimum.getData());
                node.setData(minimum.getData());
                minimum.setLevel(node.getLevel());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar el nodo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Punto 7
    public void LastLevel() {
        LastLevel(getRoot());
    }

    public void LastLevel(BinaryNode currentRoot) {
        //...
        if (currentRoot != null) {
            LastLevel(currentRoot.getLeft());
            if (currentRoot.getLevel() == getMaxLevel()) {
                System.out.print(currentRoot.getData() + " ");
            }
            LastLevel(currentRoot.getRight());
        }
    }

    //Punto 8
    public void LevelOrder() {
        LevelOrder(getRoot(), 0);
    }

    private void LevelOrder(BinaryNode currentRoot, int currentLevel) {
        //...
        /* 
        Para mostrar los datos se recomienda usar:
            System.out.print(x.getData()+" ");
        donde x representa un nodo del árbol

        Para generar un salto de linea se recomienda usar:
            System.out.print("\n");
         */
//        System.out.println(currentLevel);
        for (int i = 0; i <= getMaxLevel(); i++) {
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

    public int getMaxLevel() {
        getMaxLevel(getRoot());
        return maxLevel;
    }

    private void getMaxLevel(BinaryNode currentRoot) {
        if (currentRoot != null) {
            getMaxLevel(currentRoot.getLeft());
            if (currentRoot.getLevel() > maxLevel) {
                maxLevel = currentRoot.getLevel();
            }
            getMaxLevel(currentRoot.getRight());
        }
    }

    public String SearchLevel(int level) {
        return SearchLevel(level, getRoot());
    }

    private String SearchLevel(int level, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return "";
        } else if (level == currentRoot.getLevel()) {
            return currentRoot.getData() + "";
        } else {
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

    /**
     * @return the root
     */
    public BinaryNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(BinaryNode root) {
        this.root = root;
    }
}
