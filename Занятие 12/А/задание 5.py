def GetSumA(A):
    if A // 10 == 0:
        return A
    else:
        print(A % 10)
        return GetSumA(A // 10)

print(GetSumA(123))
