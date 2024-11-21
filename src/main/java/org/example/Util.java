package org.example;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        int i = 0, j = 0;
        while (result.size() < k && i < nums1.length && j < nums2.length) {
            int sum = nums1[i] + nums2[j];
            result.add(new int[]{nums1[i], nums2[j]});
            if (result.size() == k) break;

            // 移动到下一个较小的元素
            if (j == nums2.length - 1) {
                i++;
            } else if (i < nums1.length - 1 && nums1[i + 1] + nums2[j] <= nums1[i] + nums2[j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 输入处理和结果输出逻辑
    }
}