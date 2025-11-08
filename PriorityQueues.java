/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.priorityqueues;

/**
 *
 * @author nianc
 */

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueues {

    public interface Entry<E, V>{
        E getKey();
        V getValue();
    }
    
    public static class PQEntry< E, V> implements Entry<E,V> {
        private E key;
        private V value;
        
        public PQEntry(E key, V value){
            this.key = key;
            this.value = value;
        }
        
        public E getKey(){
            return key;
        }
        
        public V getValue(){
            return value;
        }
        
        public String toString() {
            return "(" + key + value + ")";
            
        }
        
        public static class PriorityQueue<E, V> {
            private ArrayList<PQEntry<E, V>> queue = new ArrayList<>();
            private Comparator<E> comparator;
            
            public PriorityQueue(Comparator<E> comparator){
                this.comparator = comparator;
            }
            
            public void insert(E key, V value){
                PQEntry<E,V> entry = new PQEntry<>(key, value);
                queue.add(entry);
                queue.sort((a,b)-> comparator.compare(a.getKey(),b.getKey()));
            }
            
            public PQEntry<E,V> min(){
                if(queue.isEmpty()){
                    return null;
                }    
                    return queue.get(0); 
            }
            
            public PQEntry<E, V> removeMin(){
                if(queue.isEmpty()){
                    return null;
                }
                return queue.remove(0);
            }
            
            public void display(){
                for(PQEntry<E,V> entry : queue){
                    System.out.print(entry + " ");
                }
                System.out.println();
            }
        }
        public static void main(String[] args){
            PriorityQueue<Integer,String> pq = new PriorityQueue<>(Integer::compare);
            
            pq.insert(4, "Paul");
            pq.insert(1, "Sam");
            System.out.println("Priority Queue after insertion");
            pq.display();
            
            System.out.println("Minimium element: " + pq.min());
            pq.removeMin();
            
            System.out.println("After removing Min:");
            pq.display();
            
        }
    }
    
}
