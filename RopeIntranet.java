import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RopeIntranet {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		in.nextLine(); // get extra newline
		StringBuilder output = new StringBuilder();
		
		// loop for cases
		for (int i = 1; i <= T; ++i)
		{
			// get ropes
			int N = in.nextInt();
			in.nextLine(); // get extra newline			
			int[] leftFloors = new int[N];
			Map<Integer, Integer> floorsMap = new HashMap<Integer, Integer>();			
			for (int j = 0; j < N; ++j)
			{
				String input = in.nextLine();
				String[] inputArr = input.split(" ");				
				leftFloors[j] = Integer.parseInt(inputArr[0]);
				floorsMap.put(leftFloors[j], Integer.parseInt(inputArr[1]));
			}
			
			// check for intersections
			Arrays.sort(leftFloors);
			int intersectionCount = 0;
			for (int j = 0; j < N - 1; ++j)
			{
				for (int k = j + 1; k < N; ++k)
				{
					if (floorsMap.get(leftFloors[j]) > floorsMap.get(leftFloors[k]))
					{
						intersectionCount++;
					}
				}
			}
			output.append(String.format("Case #%d: %d\n", i, intersectionCount));
		}
		in.close();
		System.out.println(output);
	}
}
