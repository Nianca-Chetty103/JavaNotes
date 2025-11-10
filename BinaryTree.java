/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarytree;

/**
 *
 * @author nianc
 */

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<E extends Comparable<E>>{
    
    private static class Node<E> {
         
        E value;
        Node<E> left;
        Node<E> right;
        
        Node(E value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
     
    private Node<E> root;
    
    public BinaryTree(){
        this.root = null;
    }
    
    //-------Insert Methods----
    /**
     * Public method to add a new value to the tree.
     * This is the "starter" method that calls the recursive helper.
     */
    
    public void insert(E value ){
        root= insertRecursive(root, value);
    }
    
    private Node<E> insertRecursive(Node<E> currentNode, E value ){
        // Base Case: We found an empty spot (a null child).
        if (currentNode == null){
            return new Node<>(value);    
        }
        //---Recursive Step: Go left or right ---
        if( value.compareTo(currentNode.value) < 0){
            currentNode.left = insertRecursive(currentNode.left, value);
        }
        //if ( value > currentNode.value)
        else if( value.compareTo(currentNode.value) > 0) {
            // Go right
            currentNode.right = insertRecursive(currentNode.right, value);
            
        }
        // else: value is equal, We do nothing (no duplicates 
        return currentNode; //return the (potentially modified) subtree.
       
    }
    //--Search method---
    public boolean search(E value){
        return searchRecursive(root, value);
    }
    
    /* 
    Private helper method to recursively search for a value.
    */
    
    private boolean searchRecursive(Node<E> currentNode, E value){
        //Base Case1: Reached an empty spot (value not found).
        if(currentNode == null){
            return false;
        }
        //BAse case 2: value is found!
        if(value.equals(currentNode.value)){
            return true;
        }
        //Recursive step: go left or right --
        if(value.compareTo(currentNode.value) < 0){
            return searchRecursive(currentNode.left, value );//search left
        }
        else {
            return searchRecursive(currentNode.right, value); //search right
        } 
    }
    //----traversal method---
    /*
    Public starter method for In-Order Traversal.
    (Left -> Root -> Right)
    This gives you the elements in sorted order.
    */
    public void inOrder(){
        System.out.print("In-Order:    ");
        inOrderRecursive(root);
        System.out.println();
    }
    
    private void inOrderRecursive(Node<E> node){
        if(node != null){
            inOrderRecursive(node.left);
            System.out.println(node.value + " ");
            inOrderRecursive(node.right);
        }
    }
    /*
    Public starter method for Pre-Order Traversal.
    (Root -> left -> right)
    Useful for copying a tree.
    */
    
    public void preOrder(){
        System.out.print("Pre-Order: ");
        preOrderRecursive(root);
        System.out.println();
    }
    
     private void preOrderRecursive(Node<E> node){
        if(node != null){
            
            System.out.println(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }
    /*
    Public starter method for Post-Order Traversal.
    (left -> right -> root)
    Useful for deleting a tree.
    */
    
    public void postOrder(){
        System.out.print("Post-Order: ");
        postOrderRecursive(root);
        System.out.println();
    }
    
     private void postOrderRecursive(Node<E> node){
        if(node != null){
          
            preOrderRecursive(node.left);//1. Visit left child 
            preOrderRecursive(node.right);// 2. Visit right child 
            System.out.println(node.value + " ");// 3. Visit root 
        }
    }
     //----Main method---
     
    public static void main(String[] args ){
        BinaryTree<Integer> bst = new BinaryTree<>();
        //insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        System.out.println("Is 40 in the tree? " + bst.search(40));
        System.out.println("Is 90 in the tree? " + bst.search(90));
        bst.inOrder();
        bst.preOrder();
        bst.postOrder();
        
        
    }
  
}
