/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practise;

/**
 *
 * @author nianc
 */
public class DoublyLinkedList<E> {
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        if(size == 0 ){
            return true;
        }else {
            return false;
        }
    }
    
    public E first(){
        if(isEmpty() == true){
            return null;
        }else
        {
            return header.getNext().getElement();
        }
    }
    
    public E Last(){
        if(isEmpty()== true){
            return null;
            
        }else {
            return trailer.getPrev().getElement();
        }
    }
    
    public void addFirst(E e){
        addBetween(e, header,header.getNext());
        
    }
    
    public void addlast(E e){
        addBetween(e, trailer.getPrev(),trailer);
    }
    
    public E removeFirst(){
        if(isEmpty()==true){
            return null;
        }else {
            return remove(trailer.getPrev());
        }
    }
    
    public E removeLast(){
        if(isEmpty()==true){
            return null;
        }else {
            return remove(trailer.getPrev());
        }
    }
    
    private void addBetween(E e, Node<E> previous , Node<E> next){
        Node<E> newest = new Node<>(e, previous,next);
        previous.setNext(newest);
        next.setPrev(newest);
        size++;
    }
    
    private E remove(Node<E> node){
        Node<E> previous = node.getPrev();
        Node<E> next = node.getNext();
        previous.setNext(next);
        next.setPrev(previous);
        size--;
        return node.getElement();
        
    }
    
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        
        
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        
        public E getElement(){
            return element;
        }
        
        public Node<E> getPrev(){
            return prev;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setPrev(Node<E> p){
            prev = p;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }
}
