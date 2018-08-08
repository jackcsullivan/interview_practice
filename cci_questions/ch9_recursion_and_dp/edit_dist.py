# Edit distance.

# Input: Two strings x[1..m], y[1..n]
# Subproblems: E(i, j) = edit distance between x[1..i] and y[1..j]
# Objective: Compute E(m, n)

def diff(i, j):
	if i != j:
		return 1
	return 0

def edit_dist(x, y):
	edit_matrix = [ [ 0 for i in range(0, len(y)) ] for j in range(0, len(x)) ]
	# Initialize first row and column.
	for i in range(0, len(x)):
		edit_matrix[i][0] = i
	for j in range(0, len(y)):
		edit_matrix[0][j] = j
	for i in range(1, len(x)):
		for j in range(1, len(y)):
			edit_matrix[i][j] = min(edit_matrix[i-1][j] + 1, edit_matrix[i][j-1] + 1, edit_matrix[i-1][j-1] + diff(x[i], y[j]))
	return edit_matrix[len(x)-1][len(y)-1]

assert edit_dist("sunny", "snowy") == 3
assert edit_dist("EXPONENTIAL", "POLYNOMIAL") == 6
