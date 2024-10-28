# -- coding: utf-8 --
print('Курс Основы программирования начался') #1

# -- coding: utf-8 --
print(16823*12302%3092) #2

# -- coding: utf-8 --
age = int(input('возраст абитуриента')) #3
name = int(input('имя абитуриента'))
if 0 < age < 75 and name != 'Иван':
    if age >= 16:
        print('Поздравляем вы поступили в ВГУИТ')
    else:
        print('Сначала нужно окончить школу!')
        print('осталось до поступления:', 16 - age)
else:
    print('не соответствует критериям')

# -- coding: utf-8 --
print("Напишите кол-во секунд") #4
sec = int(input())
print(sec//86400, (sec%86400)//3600, ((sec%86400)%3600)//60,(((sec%86400)%3600)%60))

# -- coding: utf-8 --
n = int(input()) #5
print(n + n**2 + n**3 + n**4 + n**5)
x = input()#6
y = input()
print(x,y)
x,y = y,x
print(x,y)

# -- coding: utf-8 --
print("Напишите значения a и b") #6
a=int(input())
b=int(input())
c=b
b=a
a=c
print("a-",a," b-",b)

# -- coding: utf-8 --
print("Дайте значение Num:")#7
num=int(input())
if num%2 == 0:
    print ("Num четное")
else: print("Num не четное")
    
