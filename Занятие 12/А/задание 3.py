# -- coding: utf-8 --
def GetInverseNumber(A):
    global x
    if A == 0:
        return x
    else:
        x.append(A%10)
        return GetInverseNumber(A // 10)

x = []
N = GetInverseNumber(12345)
s = ''
for y in N:
    s += str(y)
print(int(s))
