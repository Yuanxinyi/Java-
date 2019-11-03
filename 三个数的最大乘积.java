package 算法;

import java.util.ArrayList;
import java.util.List;

public class 三个数的最大乘积 {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7};
        int result = maximumProduct(data);
        System.out.println(result);
    }
    public static int maximumProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1;j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        int result1 = nums[0]*nums[1] *nums[2];
        int result2 = nums[nums.length-1] * nums[nums.length-2]*nums[0];
        return result1 > result2 ? result1 : result2 ;

    }

}
