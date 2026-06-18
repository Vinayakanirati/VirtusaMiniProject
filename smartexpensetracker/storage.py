import csv
import os
FILE_NAME = "expenses.csv"
def init_file():
    if not os.path.exists(FILE_NAME):
        with open(FILE_NAME,"w",newline="")as file:
            writer=csv.writer(file)
            writer.writerow([f"date","category","amount","description"])
def save_expenses(date,category,amount,description):
    with open(FILE_NAME,"a",newline="")as file:
        writer=csv.writer(file)
        writer.writerow([date,category,amount,description])
def load_expenses():
    expenses=[]
    if not os.path.exists(FILE_NAME):
        return expenses
    with open(FILE_NAME,"r")as file:
        reader=csv.DictReader(file)
        for row in reader:
            expenses.append({
                "date":row["date"],
                "category":row["category"],
                "amount":row["amount"],
                "description":row["description"]
            })
    return expenses