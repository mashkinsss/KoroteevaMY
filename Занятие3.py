Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> print("Введите числи а ")#1
a=int(input())
print("Введите число b ")
b=int(input())
print("Введите число c ")
c=int(input())
print("Сумма", a+b+c)


print("введите 1 катет-")#2
a=int(input())
print("введите 2 катет-")
b=int(input())
print("Площадь", 1/2*a*b)


print("введите количество минут с начала суток")#3
a=int(input())
print("Время", (a//60)%24, a%60)


print("введите расстояние между рядами")#4
a=int(input())
print("введите расстояние между дырочками")
b=int(input())
print("введите длина конца шнурка")
l=int(input())
print("введите количество дырочек")
N=int(input())
print(2*N+(2*l-1)*a+2*(l-1)*b)


print("введите первое число")#5
a=int(input())
print("введите второе ")
b=int(input())
print("введите третье")
c=int(input())
if a<b and a<c:
    d=a
elif b<c and b<a:
    d=b
else:
    d=c
print("Наименьшее", d)


print("введите строку 1")#6
a=int(input())
print("введите столбец 1")
b=int(input())
print("введите строку 2")
c=int(input())
print("введите столбец 2")
d=int(input())
e=(a+b)%2
f=(c+d)%2
if e+f==0:
    print("да")
else:
    print("нет")


print("введите год")#7
a=int(input())
if a%4==0 and a%100!=0:
    print("да")
elif a%400==0:
    print("да")
else:
    print("нет")


print("введите первое число")#8
a=int(input())
print("введите второе ")
b=int(input())
print("введите третье")
c=int(input())
if a==b and b==c:
    print(3)
elif a==b or b==c or a==c:
    print(2)
else:
    print(0)


print("введите первое число")#9
a=int(input())
print("введите второе ")
b=int(input())
print("введите третье")
c=int(input())
if n*m>k and k%n==0:
    print("да")
elif n*m>k and k%m==0:
    print("да")
else:
    print("нет")