/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insurancemanagemnetsystem;

/**
 *
 * @author nianc
 */
public class Factorial {
    
    public static int factorial(int n ) throws IllegalArgumentException{
        if(n < 0){
            throw new IllegalArgumentException();
            
        }else if (n == 0 ){
            return 1;
            
        }else {
            return n* factorial(n-1);
        }
    }
}
