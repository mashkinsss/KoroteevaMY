# -- coding: utf-8 --
def code(k):
    sum = 0
    n = int(input())
    c = 0
    while n != 0:
        sum += n
        c += 1
        n = int(input())
    return sum / c
k=int(input())
r = code(k)
print(r)
