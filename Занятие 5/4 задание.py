# -- coding: utf-8 --
def dni(x, y):
    c = 1
    while x < y:
        x *= 1.1
        c += 1
    return c
x=int(input())
y=int(input())
r=dni(x, y)
print(r)
