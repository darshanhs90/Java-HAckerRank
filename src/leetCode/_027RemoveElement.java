package leetCode;

/*
 * Link : https://leetcode.com/problems/remove-element/
 */

public class _027RemoveElement {
		public int removeElement(int[] nums, int val) {
			int index=0;
			int length=nums.length;
			for (int i = 0; i < nums.length; i++) {
				if(nums[i]!=val)
				{
					nums[index]=nums[i];
					index++;
				}
				else{
					length--;
				}
			}
			return length;
		}
}