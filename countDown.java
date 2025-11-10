/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insurancemanagemnetsystem;

/**
 *
 * @author nianc
 */

//Type of Recursion method - recursion - when the program of method calls upon itself to code.
public class countDown {
    
    public static void main(String[] args){
        countdown(5);
    }
    
    public static void countdown(int n) throws IllegalArgumentException{
        if (n < 0)
        {
            throw new IllegalArgumentException();
        }
        else if (n == 0){
            return ;
        }else{
            System.out.println("" + n);
            countdown(n-1);
        }
    }
            
}

