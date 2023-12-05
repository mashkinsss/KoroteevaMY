def DivAandB(A, B):
    if A < B:
        return 0
    else:
        return (1 + DivAandB(A - B, B))

print(DivAandB(15, 4))

print(10021% 10)
