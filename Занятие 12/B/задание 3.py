def numbers(n):
    x = []
    x_new = []
    while n != 0:
        n = int(input())
        x.append(n)
    x.remove(0)
    for i in range(0, len(x), 2):
        x_new.append(x[i])
    return x_new

print(numbers(1))
