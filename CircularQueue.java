/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practise;

/**
 * Circular queue - basically a queue that never ends, just completes the queue and restarts from position one again.
 * reuses empty spaces may of left before.
 * used for:
 - cpu scheduling 
 - buffering management 
 - Traffic or call center systems or at least any systems where they need to come back to something they alreadyb tried to process but needed some more information.
 */

public class CircularQueue {

    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity]; 
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        System.out.println(value + " added to the queue");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(queue[front] + " removed from the queue");
        front = (front + 1) % capacity;
        size--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; 
        }
        return queue[front];
    }

    public boolean isFull() {
        return size == capacity; 
    }

    public boolean isEmpty() {
        return size == 0; 
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " "); 
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);

        cq.enqueue(4);
        cq.enqueue(5);
        cq.display();

        cq.dequeue(); 
        cq.display();

        cq.enqueue(6);
        cq.enqueue(7); 
        cq.display();

        System.out.println("Front element: " + cq.peek());
    }

}
