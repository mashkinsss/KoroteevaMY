# -- coding: utf-8 --
def Solution(N):
    global X
    if N == 0:
        return 1
    return (X**N) // (Solution(N-1) * N)
X = 10
print(Solution(15))
