package com.ingramat.leetcode.top.interview.q27;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class RemoveElement {
    private int myRemoveElement(int[] nums, int val) {
        ArrayList<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        int numRemoved = 0;

        while(numsList.remove(Integer.valueOf(val))){
            numRemoved++;
        }

        int k = nums.length - numRemoved;

        for(int i = 0; i < k; i++){
            nums[i] = numsList.get(i);
        }

        return k;
    }

    public int myRemoveElement2(int[] nums, int val){
        int valCount = 0;
        int j = nums.length - 1;

        int i = 0;

        while(i <= j){
            if(nums[j] == val){
                j--;
                valCount++;
            } else {
                if (nums[i] == val){
                    nums[i] = nums[j];
                    valCount++;
                    i++;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return nums.length - valCount;
    }

    @Test
    public void test1(){
        var nums = new int[]{3,2,2,3};
        var val = 3;
        var expectedNums = new int[]{2,2};

        int k = myRemoveElement2(nums, val);

        assert k == expectedNums.length;
        sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }


    @Test
    public void test2(){
        var nums = new int[]{0,1,2,2,3,0,4,2};
        var val = 2;
        var expectedNums = new int[]{0,0,1,3,4};

        int k = bestRemoveElement(nums, val);

        assert k == expectedNums.length;
        sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test3(){
        var nums = new int[]{1};
        var val = 1;
        var expectedNums = new int[]{};

        int k = myRemoveElement2(nums, val);

        assert k == expectedNums.length;
        sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    /* OTHER SOLUTIONS FROM LEETCODE */
    public int bestRemoveElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
