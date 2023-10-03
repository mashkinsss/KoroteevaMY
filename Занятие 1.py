Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> print('Курс Основы программирования начался')
Курс Основы программирования начался
>>> print(16823*12302%3092)
2802
>>> 
age = int(input('возраст абитуриента'))
name = int(input('имя абитуриента'))
if 0 < age < 75 and name != 'Иван':
    if age >= 16:
        print('Поздравляем вы поступили в ВГУИТ')
    else:
        print('Сначала нужно окончить школу!')
        print('осталось до поступления:', 16 - age)
else:
    print('не соответствует критериям')
    
возраст абитуриента
Traceback (most recent call last):
  File "<pyshell#2>", line 2, in <module>
    age = int(input('возраст абитуриента'))
ValueError: invalid literal for int() with base 10: ''
>>> age = int(input('17'))
if age>=16:
    print("Поздравляем, Вы поступили в ВГУИТ")
else:
    print("сначала нужно окончить школу")
if 0< age < 75:
    print(True)
else:
    print(False)
name = "Илья"
if name != "Иван":
    print(True)
else:
    print(False)
if age < 16:
    print("осталось учиться", 16 - age, "лет")
    
17
Traceback (most recent call last):
  File "<pyshell#3>", line 1, in <module>
    age = int(input('17'))
ValueError: invalid literal for int() with base 10: ''
>>> seconds = int(input())
dni = seconds//86400
chas = (seconds%86400)//3600
minut = ((seconds%86400)%3600)//60
sec = ((seconds%86400)%3600)%60
print(dni,chas,minut,sec)
SyntaxError: multiple statements found while compiling a single statement
>>> seconds = int(input('1000008'))
dni = seconds//86400
chas = (seconds%86400)//3600
minut = ((seconds%86400)%3600)//60
sec = ((seconds%86400)%3600)%60
print(dni,chas,minut,sec)
1000008
Traceback (most recent call last):
  File "<pyshell#5>", line 1, in <module>
    seconds = int(input('1000008'))
ValueError: invalid literal for int() with base 10: ''
>>> seconds = 1000008
dni = seconds//86400
chas = (seconds%86400)//3600
minut = ((seconds%86400)%3600)//60
sec = ((seconds%86400)%3600)%60
print(dni,chas,minut,sec)
SyntaxError: multiple statements found while compiling a single statement
>>> 