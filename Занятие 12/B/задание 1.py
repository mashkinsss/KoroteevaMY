# -- coding: utf-8 --
def numbers(n):
    x = n
    while n != 0:
        n = int(input())
        x = max(x, n)
    return x

print(numbers(1))
