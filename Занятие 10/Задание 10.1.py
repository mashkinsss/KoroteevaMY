Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> # -- coding: utf-8 --
def sort_rows(matrix):
    sorted_matrix = [sorted(row) for row in matrix]
    return sorted_matrix
def read_matrix_from_file(file_name):
    with open(file_name, 'r') as file:
        matrix = []
        for line in file:
            row = list(map(int, line.split()))
            matrix.append(row)
    return matrix
def write_matrix_to_file(matrix, file_name):
    with open(file_name, 'w') as file:
        for row in matrix:
            file.write(' '.join(map(str, row)) + '\n')
input_file_name = 'Movsarov_U232_vvod.txt'
output_file_name = 'Movsarov_U232_vivod.txt'
user_matrix = read_matrix_from_file(input_file_name)
sorted_matrix = sort_rows(user_matrix)
write_matrix_to_file(sorted_matrix, output_file_name)
print(f'Упорядоченная матрица записана в файл {output_file_name}.')