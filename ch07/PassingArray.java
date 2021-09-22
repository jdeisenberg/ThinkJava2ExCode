/*
 * Demonstrate that passing an array to a method passes a 
 * reference, thus allowing a program to modify the array's
 * contents.
 */

public class PassingArray {
    public static void squareArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }
    
    public static void main(String[] args) {
        double [] data = {4.0, 7.0, 2.5};
        squareArray(data);
        System.out.println(java.util.Arrays.toString(data));
    }
    
}
