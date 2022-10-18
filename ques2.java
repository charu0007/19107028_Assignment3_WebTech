import java.util.*;
public class ques2 {
    public static void main(String[] args){
        int array [] = {4,7,8,5,6,3,2,6,5,4};
        int n = array.length;
        int [] output = new int[n+1];
        int max = array[0];
        for (int i = 1; i < n; i++) {
          if (array[i] > max)
            max = array[i];
        }
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < n; i++) {
          count[array[i]]++;
        }
    
        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
          count[i] += count[i - 1];
        }
    
        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = n - 1; i >= 0; i--) {
          output[count[array[i]] - 1] = array[i];
          count[array[i]]--;
        }
    
        // Copy the sorted elements into original array
        for (int i = 0; i < n; i++) {
          array[i] = output[i];
          System.out.print(array[i] + " ");
        }
    }
}
