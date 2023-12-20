package ArraysAndStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class SlidingWindow {
//   Example 1: Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum
//    is less than or equal to k. This is the problem we have been talking about above. We will now formally solve it.

//   Example 2: You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip it to a "1".
//    What is the length of the longest substring achievable that contains only "1"?
//    For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.

//    Example 3: 713. Subarray Product Less Than K.
//    Given an array of positive integers nums and an integer k, return the number of subarrays where the product of all the
//    elements in the subarray is strictly less than k.
//    For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8. The subarrays with products less than k are:
//    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]

//    Example 4: Given an integer array nums and an integer k,
//    find the sum of the subarray with the largest sum whose length is k.
    public static void main (String [] args) {
            System.out.println(longestSubArray(new int[]{1,4,1,2,3,6,3,1,1,1,1,2}, 6));
        System.out.println(longestSubstringWithAllOnes("1100001100111"));
        System.out.println(subArrayProductLessThank(new int[]{10, 5, 2, 6}, 50));
        System.out.println(sumOfSubArrayGivenLength(new int[]{3, -1, 4,12, -8, 5,6}, 4));
    }
    private static int sumOfSubArrayGivenLength(int[] nums, int k) {
        int left = 0;
        int maxSum = 0;
        double x = Double.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            if (right - left + 1 == k) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                maxSum = Math.max(maxSum, Arrays.stream(Arrays.copyOfRange(nums, left, right + 1)).sum());
                left++;
            }
        }

        return maxSum;
    }

    private static int longestSubstringWithAllOnes(String number) {
        int left = 0, right = 0;
        int zeroFrequency = 0;
        int maxLength = 0;
        for (int i=0; i<number.length(); i++) {
            right++;
            if (number.charAt(i) == '0') {
                zeroFrequency++;
                while (zeroFrequency > 1) {
                    System.out.println("here at " +zeroFrequency);
                    zeroFrequency--;
                    left = i;
                }
            }

            maxLength = Math.max(maxLength, (right -left));
        }

        return maxLength;
    }

    private static int longestSubArray(int[] nums, int k) {

        // left to track left, right to track right, keep moving but track first 0 occurrence.
        // when you see another 0, reset left until the next 1 after the 0 index.

        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxLength = 0;
        for (int i=0; i <nums.length; i++) {
            currentSum+=nums[i];
            // System.out.println("current number "+nums[i]);
            right++;
            if (currentSum > k) {
                while (currentSum > k) {
                  //  System.out.println("above number "+nums[i]);
                    currentSum-= nums[left];
                    left++;
                }
                // System.out.println("final sum "+currentSum+ " left  "+left+"  right  "+ right);
            }

            maxLength = Math.max(maxLength, right -left) ;

        }
        return maxLength;
    }


    private static int subArrayProductLessThank(int[] nums, int k) {
        // have a left pointer from 0 and right from 0
        // iterate through nums, check if current value is < k, increase product counter
        // always increase the right pointer
        // locally compute the product from left the right, check if the product < 100, then increase product counter
        // if greater than 100, increase left pointer
        // [10, 5, 2, 6]
        int subArrayCounter = 0, left = 0;

        for(int right = 0; right < nums.length; right++) {
            int localProduct = 1;
            int lowerEnd = left;
            while (lowerEnd <= right) {
                localProduct *=nums[lowerEnd];
                if (localProduct < k) {
                    subArrayCounter++;
                }
                lowerEnd++;
            }

             if (localProduct >= k) {
                left++;
            }
        }

        return subArrayCounter;
    }
}
