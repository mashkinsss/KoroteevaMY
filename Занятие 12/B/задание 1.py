Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> def numbers(n):
    x = n
    while n != 0:
        n = int(input())
        x = max(x, n)
    return x

print(numbers(1))