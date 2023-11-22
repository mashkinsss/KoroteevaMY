Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> def code(matrix, k):
diagonal_element = matrix[k][k]
for i in range(len(matrix[k])):
matrix[k][i] = matrix[k][i] / diagonal_element
def code2(matrix, k):
diagonal_element = matrix[k][k]
d = [element / diagonal_element for element in matrix[k]]
return d
n= 3
k= 1
matrix = [I1, 2, 3], [4, 5, 61, [7, 8, 9]]
code(matrix, k)
print (matrix)
n = 3
k = 1 
matrix  = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
code(matrix, k)
print(matrix)