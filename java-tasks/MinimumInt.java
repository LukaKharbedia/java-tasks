import java.util.Arrays;


public class MinimumInt {
    public static int findInt(int[] arr) {      
        Arrays.sort(arr);
        int smallestMissing = 1; 
        for (int num : arr) {
            if (num == smallestMissing) {
               
                smallestMissing++;
            } else if (num > smallestMissing) {
                break;
            }
        }
        return smallestMissing;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 1, 2 ,  1, 3, 3};
        int c = findInt(nums);
        System.out.println("The smallest integer not in the array is: " + c);
    }
}
