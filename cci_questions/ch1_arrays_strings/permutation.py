# Given two strings, write a method to decide if one of them is a permutation of another.

def sort_string(s):
	return ''.join(sorted(s))

# Simply sort both strings and compare them in equality
# Runtime: O(nlogn).
# Space: O(logn) depends on sorting alg.
def is_permutation_sol1(str1, str2):
	str1, str2 = sort_string(str1), sort_string(str2)
	return str1 == str2

# Data structure to count characters.
# Runtime: O(n).
# Space: O(1) if ascii, O(n) trivial way.
def is_permutation_sol2(str1, str2):
	if len(str1) != len(str2):
		return False
	ascii_list = [None] * 128

	for c in str1:
		c_index = ord(c)
		if ascii_list[c_index] is None:
			ascii_list[c_index] = 1
		else:
			ascii_list[c_index] += 1

	for c in str2:
		c_index = ord(c)
		if ascii_list[c_index] is None:
			return False
		ascii_list[c_index] -= 1
		if ascii_list[c_index] < 0:
			return False
	return True
	 
# Tests

assert is_permutation_sol1("abc", "bca") == True
assert is_permutation_sol2("abc", "bca") == True

assert is_permutation_sol1("abcd", "beca") == False
assert is_permutation_sol2("abcd", "beca") == False
