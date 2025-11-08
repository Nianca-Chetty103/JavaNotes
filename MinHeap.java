/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practise;

/**
 *
 * @author nianc
 */

import java.util.ArrayList;
import java.util.Collections;

public class MinHeap {
    
    private ArrayList<Integer> heap;
    
    public MinHeap(){
        this.heap = new ArrayList<>();
    }
    
    private int parent(int index){
        return (index -1) / 2;
    }
    
    private int LeftChild(int index){
        return 2 * index + 1;
    }
    
    private int RightChild(int index){
        return 2* index + 2;
    }
    
    public void add(int value ){
        heap.add(value);
        int currentIndex = heap.size()-1;
        
        while(currentIndex > 0 && heap.get(currentIndex)< heap.get(parent(currentIndex))){
           Collections.swap(heap, currentIndex, parent(currentIndex));
           currentIndex = parent(currentIndex);
        }
    }
    
    public Integer poll(){
        if(heap.isEmpty()){
            return null;
        }
        
        int highItem = heap.get(0);
        int lastItem = heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,lastItem);
            bubbledown(0);
        }
        return highItem;
    }
    
    private void bubbledown(int currentIndex){
        int smallestchild = currentIndex;
        
        while(true){
            int left = LeftChild(currentIndex);
            int right = RightChild(currentIndex);
            int Currentsmall = smallestchild;

            
            if(left < heap.size() && heap.get(left) < heap.get(Currentsmall)){
                Currentsmall = left;
            }
            
             
            if(right < heap.size() && heap.get(right) < heap.get(Currentsmall)){
                Currentsmall = right;
            }
        
        
            if(Currentsmall == currentIndex){
            break;
            }
        
            Collections.swap(heap, currentIndex, Currentsmall);
            currentIndex = Currentsmall;
        
        }
    }
    
    
}
