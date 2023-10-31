# -- coding: utf-8 --
def code(lst):
    total_sum = sum(lst)
    p = 1
    for num in lst:
        p *= num
    return total_sum, p
numbers = [1, 2, 3, 4, 5, 6, 7]
sum_results, p_result = code(numbers)
print(f"Сумма элементов списка: {sum_result}")
print(f"Произведение элементов списка: {p_result}")
