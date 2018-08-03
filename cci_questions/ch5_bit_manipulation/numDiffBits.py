import math
# Cracking the Coding Interview
# Chapter 5 Question 5

# Returns number of unequal bits of binary representations of
# integers x and y.
def numDiffBits(x, y):
	num_bits = math.ceil(math.log(max(x, y), 2))
	count = 0;
	for i in range(0, num_bits):
		count += ((x >> i) & 1) ^ ((y >> i) & 1)
	return count

assert numDiffBits(6, 11) == 3
