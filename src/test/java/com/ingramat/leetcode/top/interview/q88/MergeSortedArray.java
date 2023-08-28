package com.ingramat.leetcode.top.interview.q88;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortedArray {

    public void myMerge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_counter = 0;
        int nums2_counter = 0;
        int nums1_chosen_counter = 0;

        if(n == 0) return;

        while(nums1_counter < m + n && nums2_counter < n){
            if(nums1_chosen_counter >= m){
                nums1[nums1_counter] = nums2[nums2_counter];
                nums1_counter++;
                nums2_counter++;
                continue;
            }

            if (nums1[nums1_counter] > nums2[nums2_counter]){
                for (int i = m + n - 1; i > nums1_counter; i--){
                    nums1[i] = nums1[i - 1];
                }
                nums1[nums1_counter] = nums2[nums2_counter];
                nums2_counter++;
            } else {
                nums1_chosen_counter++;
            }

            nums1_counter++;
        }
    }

    @Test
    public void test1(){
        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        var nums2 = new int[]{2, 5, 6};
        var m = 3;
        var n = 3;

        myMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);
    }

    @Test
    public void test2(){
        var nums1 = new int[]{1};
        var nums2 = new int[0];
        var m = 1;
        var n = 0;

        myMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(1);
    }

    @Test
    public void test3(){
        var nums1 = new int[]{0};
        var nums2 = new int[]{1};
        var m = 0;
        var n = 1;

        myMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(1);
    }

    @Test
    public void test4(){
        var nums1 = new int[]{2,0};
        var nums2 = new int[]{1};
        var m = 1;
        var n = 1;

        myMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(1,2);
    }

    @Test
    public void test5(){
        var nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        var nums2 = new int[]{1,2,2};
        var m = 6;
        var n = 3;

        myMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(-1,0,0,1,2,2,3,3,3);
    }

    /* OTHER SOLUTIONS FROM LEETCODE */

    public void simpleMerge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }

    public void bestMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    @Test
    public void test6(){
        var nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        var nums2 = new int[]{1,2,2};
        var m = 6;
        var n = 3;

        simpleMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(-1,0,0,1,2,2,3,3,3);
    }

    @Test
    public void test7(){
        var nums1 = new int[]{-1,0,0,3,3,3,0,0,0};
        var nums2 = new int[]{1,2,2};
        var m = 6;
        var n = 3;

        bestMerge(nums1, m, nums2, n);

        assertThat(nums1).containsExactly(-1,0,0,1,2,2,3,3,3);
    }
}
