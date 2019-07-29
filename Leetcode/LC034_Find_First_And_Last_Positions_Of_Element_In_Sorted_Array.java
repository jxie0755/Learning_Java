import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * P033 Find First and Last Positions of Element in Sorted Array
 * Medium
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1]
 */
public class LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array {

    /**
     * Version B
     * improved binary search
     * 3 binary search, find catch mid value, and Low/High of the section,
     * Then according to mid value and Low/High to find head and tail by 2 additional binary search
     * O(LogN), Space O(1)
     */
    public int[] searchRange(int[] nums, int target) {


        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        int L = 0;
        int H = nums.length - 1;
        int M = (L + H) / 2;

        // first while loop to find whether target is in the Array
        while (L <= H) {
            int check = nums[M];
            if (check < target) {
                L = M + 1;
            } else if (check > target) {
                H = M - 1;
            } else {
                break;
            }
            M = (L + H) / 2;
        }

        if (L > M) {
            return new int[]{-1, -1};
        }

        // locate head
        int Lo = L;
        int Hi = M;
        int head;
        while (true) {
            head = (Lo + Hi) / 2;
            int head_value = nums[head];

            if (head_value == target && head == 0) {
                break;
            } else if (head_value < target) {
                Lo = head + 1;
            } else if (head_value == target && nums[head - 1] == target) {
                Hi = head - 1;
            } else {
                break;
            }
        }

        // locate head
        Lo = M;
        Hi = H;
        int tail;
        while (true) {
            tail = (Lo + Hi) / 2;
            int tail_value = nums[tail];

            if (tail_value == target && tail == Hi) {
                break;
            } else if (tail_value > target) {
                Hi = tail - 1;
            } else if (nums[tail] == target && nums[tail + 1] == target) {
                Lo = tail + 1;
            } else {
                break;
            }
        }

        return new int[]{head, tail};
    }

    public static void main(String[] args) {

        int[] Q1 = new int[]{};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q1, 0),
                new int[]{-1, -1})
                : "Edge 1";

        int[] Q2 = new int[]{8};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q2, 8),
                new int[]{0, 0})
                : "Edge 2";

        int[] Q3 = new int[]{0};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q3, 8),
                new int[]{-1, -1})
                : "Edge 3";

        int[] Q4 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q4, 8),
                new int[]{3, 4})
                : "Example 1";

        int[] Q5 = new int[]{5, 7, 7, 8, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q5, 6),
                new int[]{-1, -1})
                : "Example 2";

        int[] Q6 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q6, 8),
                new int[]{4, 4})
                : "Additional 1";

        int[] Q7 = new int[]{5, 7, 7, 7, 8, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q7, 7),
                new int[]{1, 3})
                : "Additional 2";

        int[] Q8 = new int[]{1, 4};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q8, 4),
                new int[]{1, 1})
                : "Extra 1";

        int[] Q9 = new int[]{1, 3};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q9, 1),
                new int[]{0, 0})
                : "Extra 2";

        int[] Q10 = new int[]{-3, -2, -1};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q10, 0),
                new int[]{-1, -1})
                : "Extra 3";

        int[] Q11 = new int[]{0, 0, 2, 3, 4, 4, 4, 5};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q11, 5),
                new int[]{7, 7})
                : "Extra 4";

        int[] Q12 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q12, 4),
                new int[]{10, 13})
                : "Extra 5";

        int[] Q13 = new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9};
        assert Arrays.equals(
                new LC034_Find_First_And_Last_Positions_Of_Element_In_Sorted_Array().searchRange(Q13, 3),
                new int[]{2, 5})
                : "Extra 6";

        System.out.println("all passed");
    }
}
