/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practise;

/**
 *
 * @author nianc
 */
public class SinglyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    
    public boolean isEmpty()   //Check if the List is Empty
    { 
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }
    
    public T first()        //Check if the head is there else it will create the first object as the head.
    {     
        if(isEmpty() == true ){
            return null;
        }else {
            return head.getElement();
        }
    }
    
    public T Last()   //Check where the end of the list is.
    {
        if(isEmpty()== true){
            return  null;
        }else {
            return tail.getElement();
        }
    }
    
    public void addFirst(T t)  /// Add the head to the list.
    {
        head = new Node<>(t , head);
        if(isEmpty()==true ){
            tail = head ;
        }else {
            size++;
        }
    }
    
    public void addLast(T t)   ///Ensuring it knows which object is the tail / last.
    {
        Node<T> newest = new Node<>(t,null);
        if(isEmpty()==true){
            head = newest;
        }else {
            tail.setNext(newest);
        }
        tail =newest;
        size++;
    }
    
    public T removeFirst()  //once use the first object it may reassign another one as the head
    {
        if(isEmpty() == true){
            return null;
        }else {
            T answer =head.getNext().getElement();
            head = head.getNext();
            size--;
          
            if(isEmpty()== true ){
            tail = null;
        }  
        return answer; 
        }
    }
    
    public static class Node<T> //Node class
    {     
        private T element ;
        private Node<T> next;
        
        public Node(T t, Node<T> n){
            element = t;
            next = n ;
        }
        
        public T getElement(){
            return element;        
        }
        
        public Node<T> getNext(){
            return next;
        }
        
        public void setNext(Node<T> n){
            next = n;
        }
    }
    
}

