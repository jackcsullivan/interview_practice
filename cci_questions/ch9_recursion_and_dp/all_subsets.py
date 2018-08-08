
# Cracking the Coding Interview
# Chapter 9 Question 4

def all_subsets(s):
	if len(s[0]) == 0:
		return [[]]
	if len(s[0]) == 1:
		return [[], s]
	if len(s[0]) == 2:
		return [[], [s[0][0]], [s[0][1]], s[0]]

	elem = s[0].pop()

	# First half of subsets don't include elem.
	other_subsets = all_subsets(s)
	next_subsets = []

	# Next half are the old subsets with elem appended.
	for subset in other_subsets:
		new_subset = subset.copy()
		new_subset.append(elem)
		next_subsets.append(new_subset)
	for subset in next_subsets:
		other_subsets.append(subset)
	return other_subsets

s = []
s.append(1)
s.append(2)
s.append(3)
s.append(4)
print(all_subsets([s]))
