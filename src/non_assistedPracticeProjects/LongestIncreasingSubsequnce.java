package non_assistedPracticeProjects;
import java.util.*;

public class LongestIncreasingSubsequnce {
	public static void main(String args[])
	{
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		if (arr == null || arr.length == 0) {
			return;
		}

		List<List<Integer>> LIS = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			LIS.add(new ArrayList<>());
		}

		LIS.get(0).add(arr[0]);

		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{ 
				if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
					LIS.set(i, new ArrayList<>(LIS.get(j)));
				}
			}

			LIS.get(i).add(arr[i]);
		}

		int j = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (LIS.get(j).size() < LIS.get(i).size()) {
				j = i;
			}
		}

		System.out.print(LIS.get(j));
	}
}
