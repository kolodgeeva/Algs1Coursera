package main.java.threesum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 9/28/2016.
 */
public class HashMapThreeSum {

    public static int[] threeSum(final int[] n) {

        Map<Integer, int[]> map = new HashMap<>();
        int l = n.length;
        for (int i = 0; i < l; i++) {
            map.clear();
            for (int j = i + 1; j < l; j++) {
                if (map.containsKey(n[j])) {
                    int[] pair = map.get(n[j]);
                    return new int[]{pair[0], pair[1], n[j]};
                } else
                    map.put(-n[i] - n[j], new int[]{n[i], n[j]});
            }
        }
        return null;

    }

    public static void main(final String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(arr)));

    }
}
