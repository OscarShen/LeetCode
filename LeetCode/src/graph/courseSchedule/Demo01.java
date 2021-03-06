package graph.courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo01 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> posts = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			posts.add(new ArrayList<Integer>());
		}

		int[] preNums = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
			preNums[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (preNums[i] == 0) {
				queue.offer(i);
			}
		}

		int count = numCourses;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : posts.get(cur)) {
				if (--preNums[i] == 0) {
					queue.offer(i);
				}
			}
			count--;
		}

		return count == 0;
	}
}
