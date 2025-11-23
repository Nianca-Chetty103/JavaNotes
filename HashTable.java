/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singlylinkedlists;

import java.util.LinkedList;



/**
 *
 * @author nianc
 */
// this is for checking / adding words to a dictionary 

class HashTable {
    private LinkedList<String> [] table;
    private int size;
    
    public HashTable(int size){
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i ++){
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(String key){
        int hash = 0;
        for( int i = 0; i < key.length(); i++){
            hash = 31 * hash + key.charAt(i)% size ;
        }
        return hash;
    }
    
   
    public void insert( String word){
        int index = hash(word);
        if (!table[index].contains(word)){
            table[index].add(word);
        }
    }
    
    public boolean contains( String word){
        int index = hash(word);
        return table[index].contains(word);
    }

}
