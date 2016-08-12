package array.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s1 = new HashSet<>();
		for (int t : nums1) {
			s1.add(t);
		}
		Set<Integer> s2 = new HashSet<>();
		for (int t : nums2) {
			if (s1.contains(t)) {
				s2.add(t);
			}
		}
		Iterator<Integer> it = s2.iterator();
		int[] nums3 = new int[s2.size()];
		int i = 0;
		while (it.hasNext()) {
			nums3[i++] = it.next();
		}
		return nums3;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 4 };
		int[] nums2 = { 2, 3, 4, 5 };
		for (int t : new IntersectionOfTwoArrays().intersection1(nums1, nums2)) {
			System.out.print(t + "\t");
		}
	}

	public int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> s = new HashSet<>();
		Arrays.sort(nums1);
		for (int n : nums2) {
			if (search(nums1, n)) {
				s.add(n);
			}
		}
		int[] nums3 = new int[s.size()];
		int i = 0;
		for (int n : s) {
			nums3[i++] = n;
		}
		return nums3;
	}

	public boolean search(int[] nums, int n) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == n) {
				return true;
			} else if (nums[mid] < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
