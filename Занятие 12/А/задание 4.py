def GetSumA(A):
    global s
    if A == 0:
        return s
    else:
        s += A % 10
        return GetSumA(A // 10)

s = 0
print(GetSumA(123))
