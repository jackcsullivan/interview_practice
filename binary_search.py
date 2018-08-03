# Key is element we are looking for.
# List is the SORTED list we are searching through.
# Min and max are range parameters of the list.
# Return index of element we are looking for.
def binary_search(key, list, min, max):
	if max < min:
		return -1
	midpoint = (min + max) // 2
	print(midpoint)
	if key < list[midpoint]:
		return binary_search(key, list, min, midpoint - 1)
	elif key > list[midpoint]:
		return binary_search(key, list, midpoint + 1, max)
	return midpoint

assert binary_search(5, [1, 2, 5, 6, 7, 8], 0, len([1, 2, 5, 4, 6, 7, 8]) - 1) == 2
