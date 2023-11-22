# -- coding: utf-8 --
def code(matrix, k):
  diagonal_element = matrix[k][k]
  for i in range(len(matrix[k])):
    matrix[k][i] = matrix[k][i] / diagonal_element
def code2(matrix, k):
  diagonal_element = matrix[k][k]
  d = [element / diagonal_element for element in matrix[k]]
  return d
n=3
k=1
matrix = [I1, 2, 3], [4, 5, 61, [7, 8, 9]]
code(matrix, k)
print (matrix)
n = 3
k = 1 
matrix  = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
d = code2(matrix, k)
print(d)
