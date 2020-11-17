package Leetcode2020Nov;

public class _0055JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 2, 0, 4 }));
	}

	public static boolean canJump(int[] nums) {
		int finalIndex = nums.length - 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] + i >= finalIndex) {
				finalIndex = i;
			}
		}
		return finalIndex == 0;
	}
}
