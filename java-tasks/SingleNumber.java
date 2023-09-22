public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber finder = new SingleNumber(); // Create an instance of SingleNumber
        int[] nums = {4, 4, 2, 1, 2, 1, 3};
        int single = finder.singleNumber(nums);
        System.out.println("The single number is: " + single);
    }
}
