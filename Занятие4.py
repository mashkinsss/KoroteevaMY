Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> a=int(input())#1
b=int(input())
while a<=b:
    print(a)
    a=a+1

a=int(input())#2
b=int(input())
if a<b:
    while a<=b:
        print(a)
        a=a+1
else:
    while b<=a:
        print(a)
        a=a-1


a=int(input())#3
b=int(input())
while a>=b:
    if a%2!=0:
        print(a)
    a=a-1


print("введите кол-во n")#4
n=int(input())
b=0
while n>0:
    print("введите число №",n)
    a=int(input())
    b=b+a
    n=n-1

print(b)


print("введите число n")#5
n=int(input())
b=0
while n>0:
    a=n**3
    b=b+a
    n=n-1

print(b)

print("введите число n")#6
n=int(input())
b=1
while n>0:
    b=b*n
    n=n-1

print(b)

print("введите число n")#7
n=int(input())
b=1
c=0
v=1
while v<=n:
    b=b*v
    c=b+c
    v=v+1

print(c)


n = int(input())#8
for i in range(1, n + 1):
    for j in range(1, i + 1):
        print(j,end="")
    print()


n=int(input())#9
f1=1
f2=1
k=3
s==2
while k<=n:
    f3=f1+f2
    s=f3+s
    f1=f2
    f2=f3
    k+=1
print(s)
SyntaxError: multiple statements found while compiling a single statement
>>> n=int(input())
k=int(input())
Traceback (most recent call last):
  File "<pyshell#1>", line 1, in <module>
    n=int(input())
ValueError: invalid literal for int() with base 10: 'k=int(input())'
>>> f1=f2=1
>>> k=0
>>> c=0
>>> f3=0
>>> s=0
>>> s1=0
>>> while k <n:
	c += 1
	if c <= 2:
		f3=1
	else:
		f3=f1+2
		f1=f2
		f2=f3
	if  c >= K:
		s = s + f3
		k += 1
print(s)f1=f2=1
SyntaxError: invalid syntax
>>> 