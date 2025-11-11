/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithms;

/**
 *
 * @author nianc
 */
//----- Notes ------

public class BubbleSort {

    public <T extends Comparable <T>> void sort(T[] arr) {
        int n = arr.length();
        boolean swapped;

        for ( int i = 0; i < n - 1 ; i++) {
        swapped = false;
            for (int j = 0; j < n -1 -i; i++ ) {
                if ( arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
        if ( !swapped ) {
            break;
        }
        }
    }
}

