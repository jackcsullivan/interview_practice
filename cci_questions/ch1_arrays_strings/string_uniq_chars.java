import java.util.HashMap;
import java.util.Arrays;

public class string_uniq_chars {
	

	/* 
	# Determine if a string has all unique characters?
	# Solution 1: Use a set (or dictionary for more efficient runtime) to check if we have
	# 			  seen that character before.
	# Runtime: O(n)
	# Space: O(n)
	*/ 
	public static boolean uniqueCharsSol1(String s) {
		HashMap<Character, Character> hmap = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (hmap.containsKey(c)) {
				return false;
			}
			hmap.put(c, c);
		}
		return true;
	}

	/*
	# What if you cannot use additional data structures?
	# Solution 2: Sort the string then check characters sequentially.
	# Runtime: O(n log(n))
	# Space: O(1)
	*/

	// Method to sort a string alphabetically
    public static String sortString(String inputString) {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
    }

	public static boolean uniqueCharsSol2(String s) {
	    String sortedString = sortString(s);
	    Character last_c = '\u0000';
	    for (int i = 0; i < sortedString.length(); i++) {
			Character c = sortedString.charAt(i);
	    	if (last_c != '\u0000') {
	    		if (c == last_c) {
	    			return false;
	    		}
	    	}
	    	last_c = c;
	    }
	    return true;
	}

    /* Tests */
	public static void main(String[] args) {
		assert uniqueCharsSol1("aa") == false;
		assert uniqueCharsSol2("aa") == false;

		assert uniqueCharsSol1("aba") == false;
		assert uniqueCharsSol2("aba") == false;

		assert uniqueCharsSol1("aswldqer");
		assert uniqueCharsSol2("aswldqer");
	}
}
