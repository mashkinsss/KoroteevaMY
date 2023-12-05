def number(a, b):
    if a <= b:
        if a == b:
            return a
        print(a)
        return number(a + 1, b)
    else:
        if a == b:
            return a
        print(a)
        return number(a - 1, b)
print(number(15, 10))
