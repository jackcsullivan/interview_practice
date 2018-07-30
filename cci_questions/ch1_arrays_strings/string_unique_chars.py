# Determine if a string has all unique characters?
# Solution 1: Use a set (or dictionary for more efficient runtime) to check if we have
# 			  seen that character before.
# Runtime: O(n)
# Space: O(n)

def unique_chars_sol1(s):
	char_map = {}
	for c in s:
		if c in char_map:
			return False
		char_map[c] = c # Doesn't matter what the value is, just checking key.
	return True

# What if you cannot use additional data structures?
# Solution 2: Sort the string then check characters sequentially.
# Runtime: O(n log(n))
# Space: O(1)

def unique_chars_sol2(s):
	''.join(sorted(s))
	last_c = None
	for c in s:
		if last_c is not None:
			if c == last_c:
				return False
		last_c = c
	return True



# Tests
assert unique_chars_sol1("aa") == False
assert unique_chars_sol2("aa") == False

assert unique_chars_sol1("aba") == False
assert unique_chars_sol1("aba") == False

assert unique_chars_sol1("aswldqer") == True
assert unique_chars_sol1("aswldqer") == True