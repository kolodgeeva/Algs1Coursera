package main.java.threesum;

import java.util.Arrays;

/**
 * Created by User on 9/28/2016.
 */
public class BinarySearchThreeSum {

    public static int[] threeSum(final int[] n) {

        int[] result = new int[3];

        if (n == null || n.length < 3)
            return result;

        Arrays.sort(n);

        for (int i = 0; i < n.length - 2; i++){
            if (i == 0 || n[i] > n[i - 1]){
                int j= i + 1;
                int k = n.length - 1;

                while (j < k){
                    if (n[i] + n[j] + n[k] == 0){
                        int[] l = new int[3];
                        l[0] = n[i];
                        l[1] = n[j];
                        l[2] = n[k];
                        result = l;

                        j++;
                        k--;

                        while (j < k && n[j] == n[j - 1])
                            j++;
                        while (j < k && n[k] == n[k + 1])
                            k--;

                    } else if (n[i] + n[j] + n[k] < 0){
                        j++;
                    } else{
                        k--;
                    }
                }
            }

        }

        return result;

    }

    public static void main(final String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(arr)));

    }
}
