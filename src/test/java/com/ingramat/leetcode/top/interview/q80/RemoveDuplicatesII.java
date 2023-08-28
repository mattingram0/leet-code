package com.ingramat.leetcode.top.interview.q80;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesII {
    private int myRemoveDuplicates(int[] nums) {
        if (nums.length < 3){
            return nums.length;
        }

        int nextAvailPos = 2;

        for (int i = 2; i < nums.length; i++){
            nums[nextAvailPos] = nums[i];
            if(nums[nextAvailPos] != nums[nextAvailPos - 1] || nums[nextAvailPos] != nums[nextAvailPos - 2]){
                nextAvailPos++;
            }
        }

        return nextAvailPos;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] expectedNums = new int[]{1,1,2,2,3};

        int k = myRemoveDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test2(){
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int[] expectedNums = new int[]{0,0,1,1,2,3,3};

        int k = myRemoveDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
