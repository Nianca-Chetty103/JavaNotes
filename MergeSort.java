/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithms;
import java.util.Arrays;
/**
 *
 * @author nianc
 */

public class MergeSort {
    public <T extends Comparable <T>> void sort(T[] arr) {
        int n = arr.length;

        if ( n < 2 ) {
            return ;
        }

        int  mid = n / 2;
        T[] lefthalf = Arrays.copyOfRange(arr, 0, mid);
        T[] righthalf = Arrays.copyOfRange(arr, mid, n);

        sort(lefthalf);
        sort(righthalf);

        merge(arr, lefthalf, righthalf);
}
    
private <T extends Comparable <T>> void merge( T[] mainArray, T[] lefthalf, T[] righthalf){
  int leftsize = lefthalf.lenth;
  int rightsize = righthalf.length;
  int i = 0;
  int j = 0;
  int k = 0;

    while ( i < leftsize && j < rightsize ) {
        if ( lefthalf[i].compareTo(righthalf[j] <= 0){
            mainArray[k] = lefthalf[i];
            i++;
        }   
      else
        {
            mainArray[k] = righthalf[j];
            j++;
        }    

   while ( i < leftsize ) {
       mainArray[k] = lefthalf[i];
       k++;
       i++;
   }

   while ( j < rightsize ) {
       mainArray[k] = righthalf[j];
       j++;
       k++;
   }     
}
}    
    
