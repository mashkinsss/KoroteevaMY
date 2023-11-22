Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> def code(matrix):
for row in matrix:
print(row)
def code2(matrix):
r = len(matrix)
c = len(matrix[0])
t = [[0 for _ in range(r)] for _ in range(c)]
for i in range(r):
for j in range(c):
t [j] [i]= matrix  [j] [i]
return t
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] 
s = code2(matrix)
print(s)