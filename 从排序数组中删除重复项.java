package 算法;

import java.util.ArrayList;
import java.util.List;

public class 从排序数组中删除重复项 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int x= removeDuplicates(nums);
        System.out.println(x);

    }
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int n=list.size();
        for (int j=0;j<n-1;j++){
            for (int k=j+1;k<n;k++){
                if (list.toArray()[j]==list.toArray()[k]) {
                    list.remove(k);
                    n = list.size();
                }
                else
                    break;
            }
        }
        for (int l=0;l<list.size();l++){
            nums[l]= (int) list.toArray()[l];
        }
        return list.size();

    }
}
