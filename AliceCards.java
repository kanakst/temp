import java.util.*;

class AliceCards {

	public static boolean solution(int[] hand, int W) {
		
		// Checking basic condition
		if (hand.length%W != 0)
            return false;
        
        // minHeap for taking smallest number first
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : hand) {
            minHeap.add(num);
        }
        
        // because of new arrays should contain consequtive numbers
        // once we poll the first number, we check if minHeap contains W - 1
        // other consequtive numbers
        while (!minHeap.isEmpty()) {
            int num = minHeap.poll();
            for (int i = 1; i < W; i++) {
                if (!minHeap.remove(num + i))
                    return false;
            }
        }
        
        return true;

	}
	
	public static void main(String[] args) {
		// Provided test cases ...
		int[] arr1 = new int[]{1,2,3,6,2,3,4,7,8};
		int w1 = 3;

		int[] arr2 = new int[]{1,2,3,4,5};
		int w2 = 4;

		System.out.print("Test1: ");

		if (solution(arr1,w1))
			System.out.println("true");
		else
			System.out.println("false");

		System.out.print("Test2: ");

		if (solution(arr2,w2))
			System.out.println("true");
		else
			System.out.println("false");
	}
}