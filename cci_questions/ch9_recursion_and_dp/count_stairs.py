from sys import setrecursionlimit
setrecursionlimit(4002)

# Cracking the Coding Interview
# Chapter 9 Question 1

results = {}

def count_stairs(n):
	if n not in results.keys():
		results[n] = _count_stairs(n)
	return results[n]

def _count_stairs(n):
	if n <= 0:
		return 0
	if n == 1:
		return 1
	if n == 2:
		return 2
	if n == 3:
		return 4
	return count_stairs(n - 1) + count_stairs(n - 2) + count_stairs(n - 3)

assert count_stairs(1) == 1
assert count_stairs(2) == 2
assert count_stairs(3) == 4
assert count_stairs(4) == 7

# Below call should take milliseconds.
count_stairs(2000)
