# -- coding: utf-8 --
def min(n):
    i = 2
    while n % i != 0:
        i += 1
    return i
n = int(input())
r = min(n)
print(r)
