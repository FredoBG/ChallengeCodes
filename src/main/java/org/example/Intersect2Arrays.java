package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer> cntNums1 = new HashMap<Integer, Integer>();
        List<Integer> inters = new ArrayList<>();

        // Counting nums1
        for (int num : nums1) {
            cntNums1.put(num, cntNums1.get(num)==null?1:cntNums1.get(num)+1);
        }

        // Check nums2 in nums1
        for (int num : nums2) {
            if (cntNums1.containsKey(num) && cntNums1.get(num) > 0) {
                inters.add(num);
                cntNums1.put(num, cntNums1.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] rslt = new int[inters.size()];
        for (int i=0; i<inters.size(); i++) {
            rslt[i] = inters.get(i);
        }

        return rslt;
    }
}
