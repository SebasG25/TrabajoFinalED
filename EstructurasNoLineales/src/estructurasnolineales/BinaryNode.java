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
public class BinaryNode {

    private int data;
    private BinaryNode left;
    private BinaryNode right;
    private boolean ChildPosition;
    private int level;

    public BinaryNode(int data) {
        setData(data);
        setLeft(null);
        setRight(null);
    }
    
     public BinaryNode(int data, int level) {
        setData(data);
        setLevel(level);
        setLeft(null);
        setRight(null);
    }

    public boolean isLeaf() {
        return ((left == null) && (right == null)) ? true : false;
    }

    public boolean hasOneChild() {
        if (left == null && right != null) {
            ChildPosition = true;
            return true;
        } else if (left != null && right == null) {
            ChildPosition = false;
            return true;
        }else{
            return false;
        }

    }
    
    public int nodosCompletos(BinaryNode node){
        if(node == null){
            return 0;
        }else{
            if(node.getLeft() != null && node.getRight() != null){
                return nodosCompletos(node.getLeft()) + nodosCompletos(node.getRight()) + 1;
            }
            return nodosCompletos(node.getLeft()) + nodosCompletos(node.getRight());
        }
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public BinaryNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /**
     * @return the ChildPosition
     */
    public boolean isChildPosition() {
        return ChildPosition;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
