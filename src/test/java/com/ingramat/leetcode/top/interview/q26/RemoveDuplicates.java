package com.ingramat.leetcode.top.interview.q26;

import org.junit.jupiter.api.Test;

public class RemoveDuplicates {
    private int myRemoveDuplicates(int[] nums) {
        int currentVal = -1000;
        int currentPos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != currentVal){
                currentVal = nums[i];
                nums[currentPos] = nums[i];
                currentPos++;
            }
        }

        return currentPos;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,1,2};
        int[] expectedNums = new int[]{1,2};

        int k = myRemoveDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test2(){
        int[] nums = new int[]{1,1,2};
        int[] expectedNums = new int[]{1,2};

        int k = myRemoveDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test3(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] expectedNums = new int[]{0,1,2,3,4};

        int k = myRemoveDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
