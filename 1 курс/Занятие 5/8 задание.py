# -- coding: utf-8 --
def code():
    n = int(input())
    c = 0
    max_c = 0
    p = n
    while n != 0:
        if n == p:
            c += 1
            if c > max_c:
                max_c = c
        else:
            c = 1
        p = n
        n = int(input())
    return max_c
r = code()
print(r)
