# -- coding: utf-8 --
def code2(matrix):  A = []
  j = 0  while j < len(matrix[1]):
    B = []    for i in range(len(matrix)):
      B.append(matrix[i][j])    j += 1
    A.append(B)  for i in range(len(A)):
    for j in range(len(A[0])):      print(A[i][j], end=' ')
    print()matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
code2(matrix)
