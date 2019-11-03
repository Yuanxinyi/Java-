package 算法;

public class 无重复字长的最长子串的长度 {
    public static void main(String[] args) {
        String s = "ababababa";
        int x = lengthOfLongestSubstring(s);
        System.out.println(x);

    }
    public static int lengthOfLongestSubstring(String s) {
        int  len,i=0,j,k,max=0;
        char[] data = s.toCharArray();
        len = data.length;
        for(j = 0;j<len;j++){
            for(k = i;k<j;k++) {
                if (data[k] == data[j]) {
                    i = k + 1;
                    break;
                }
            }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }
}

