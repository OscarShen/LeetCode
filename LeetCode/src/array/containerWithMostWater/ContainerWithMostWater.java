package array.containerWithMostWater;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int n = height.length;
		int maxArea = 0;
		int i = 0, j = n - 1;
		while (i < j) {
			int tempArea;
			if (height[i] < height[j]) {
				tempArea = height[i] * (j - i);
				i++;
			} else {
				tempArea = height[j] * (j - i);
				j--;
			}
			if (tempArea > maxArea)
				maxArea = tempArea;
		}
		return maxArea;
	}
}
