# -- coding: utf-8 --
def code(matrix):
  for row in matrix:
    print(row)
def code2(matrix):
  r = len(matrix)
  c = len(matrix[0])
  t = [[0 for _ in range(r)] for _ in range(c)]
  for i in range(r):
    for j in range(c):
      t [j][i]= matrix  [j] [i]
  return t
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]] 
s = code2(matrix)
print(s)
