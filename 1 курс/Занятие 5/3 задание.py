# -- coding: utf-8 --
def nnnnn(n):
    i = 2
    p = 1
    while i <= n:
        i *= 2
        p += 1
    return p-1, i//2
n = int(input())
r = nnnnn(n)
print(r)
