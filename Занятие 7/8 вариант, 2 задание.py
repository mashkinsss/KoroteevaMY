# -- coding: utf-8 --
def code(arr):
    min_index = arr.index(min(arr))
    max_index = arr.index(max(arr))
    arr[min_index], arr[max_index] = arr[max_index], arr[min_index]
n = [5, 9, 2, 1, 7]
print("Исходный массив:", n)
r=code(n)
print("Массив после перестановки мин и мак элементов:", n)
   
