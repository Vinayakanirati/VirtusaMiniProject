from storage import save_expenses,load_expenses
def add_expense():
    print("\n========Add Expense========")
    date=input("Enter Date (YYY-MM-DD): ")
    category=input("enter category: ")
    amount=input("enter amount: ")
    description=input("enter description : ")
    save_expenses(date,category,amount,description)
    print("expenses added successfully!")

def view_expenses():
    expenses=load_expenses()
    if not expenses:
        print("\n no expenses found\n")
        return 
    print("\n============EXPENSES=============")
    print(f"{'Date':<12}{'Category':<15}{'Amount':<10}{'description'}")
    print("-"*50)
    for expense in expenses:
        print(
            f"{expense['date']:<12}"
            f"{expense['category']:<15}"
            f"{expense['amount']:<10}"
            f"{expense['description']}"
        )
    print()

