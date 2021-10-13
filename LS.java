import java.util.*;

class LS {

	public static String solution(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		
		// i and j for window sliding, max for record the max length of the window
		// maxStart to indicate where the potential substring may start
		int i = 0, j = 0, max = 0, maxStart = 0;
    	
		// using set to keep track of seen chars
    	Set<Character> set = new HashSet<>();
    
	    while (j < s.length()) {

	    	// if char is seen for the first time:
	        if (!set.contains(s.charAt(j))) {

	        	// adding to set and incrementing the window pointer
	            set.add(s.charAt(j++));
	            // condition to update the max and maxStart
	            if (set.size() > max) {
	            	max = set.size();
	            	maxStart = i;
	            }

	        } else {
	        	// if already seen char, removing left window value at i and incrementing it
	        	// note: it doesn't have to remove the char we just seen at j, but it will keep doing so
	        	// until eventually it will delete the char we seen at j
	            set.remove(s.charAt(i++));
	        }
	    }
    
    	return sb.substring(maxStart, maxStart + max);
		
	}
	
	public static void main(String[] args) {
		String input1 = "aabaab!bb";
		String input2 = "rtsggyrgdtsvghiopkln1!ghhhjj";
		
		String res1 = solution(input1);
		String res2 = solution(input2);

		System.out.println("Given: " + input1 + " result is: " + res1);
		System.out.println("Given: " + input2 + " result is: " + res2);
	}
}