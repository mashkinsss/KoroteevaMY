Python 3.9.7 (tags/v3.9.7:1016ef3, Aug 30 2021, 20:19:38) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> import tkinter as tk
import requests
import json

def get_repository_info():
    repo_name = repo_name_entry.get()
    url = f'https://api.github.com/repos/{repo_name}'
    response = requests.get(url)

    if response.status_code == 200:
        data = response.json()
        info = {
            'company': data.get('owner', {}).get('company'),
            'created_at': data.get('created_at'),
            'email': data.get('owner', {}).get('email'),
            'id': data.get('id'),
            'name': data.get('name'),
            'url': data.get('owner', {}).get('url')
        }
        with open('repository_info.json', 'w') as file:
            json.dump(info, file, indent=4)
        result_label.config(text="Информация сохранена в файл 'repository_info.json'.")
    else:
        result_label.config(text="Репозиторий не найден или произошла ошибка при запросе.")

# Создание окна
window = tk.Tk()
window.title("GitHub Repository Info")

# Создание и размещение элементов
repo_name_label = tk.Label(window, text="Имя репозитория (например, 'kubernetes/kubernetes'): ")
repo_name_label.pack()

repo_name_entry = tk.Entry(window)
repo_name_entry.pack()

get_info_button = tk.Button(window, text="Получить информацию", command=get_repository_info)
get_info_button.pack()

result_label = tk.Label(window, text="")
result_label.pack()

# Запуск главного цикла
window.mainloop()