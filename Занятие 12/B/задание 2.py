def numbers(n):
    x = []
    while n != 0:
        n = int(input())
        x.append(n)
    x.remove(max(x))
    return max(x)

print(numbers(1))
