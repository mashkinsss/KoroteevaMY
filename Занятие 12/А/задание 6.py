# -- coding: utf-8 --
def number(n, i=2):
    if n <= 2:
        return n == 2
    if n % i == 0:
        return False
    if i * i > n:
        return True
    return numbere(n, i + 1)

N = int(input())
if number(N):
    print("YES")
else:
    print("NO")
