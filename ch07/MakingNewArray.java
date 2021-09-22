/*
 * Demonstrate that you can create a new array and return
 * it as a result, leaving the original array untouched.
 */

import java.util.Arrays;

public class MakingNewArray {
    public static void main(String[] args) {
        double [] data = {4.0, 7.0, 2.5};
        double [] squaredData = newSquareArray(data);
        System.out.println(Arrays.toString(data)); 
        System.out.println(Arrays.toString(squaredData));
    } 

    public static double[] newSquareArray(double[] arr) {
        double[] result = new double[arr.length];
    
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * arr[i];
        }   
        return result;
    }
    
}
