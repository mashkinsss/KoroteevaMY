# -- coding: utf-8 --
def code():
    n = int(input())
    c = 0
    p = n
    while n != 0:
        if n > p:
            c += 1
        p = n
        n = int(input())
    return c
r = code()
print(r)
