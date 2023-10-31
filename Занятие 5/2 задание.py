Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> # -- coding: utf-8 --
def min(n):
    i = 2
    while n % i != 0:
        i += 1
    return i
n = int(input())
r = min(n)
print(r)