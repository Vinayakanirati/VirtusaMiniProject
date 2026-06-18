from storage import load_expenses
def monthly_summary(month,year):
    expenses=load_expenses()
    total=0
    for expense in expenses:
        date=expense["date"]
        e_year,e_month,_=date.split("-")
        if int(e_month)==month and int(e_year)==year:
            total+=int(expense["amount"])
    print(f"\n total expenses for {month}/{year}: ${total:.2f}")
def category_breakdown():
    expenses=load_expenses()
    categories={}
    for expense in expenses:
        category =expense["category"]
        if category not in categories:
            categories[category]=0
        categories[category]+=int(expense["amount"])
    print("\n category wise expenses")
    for category,amount in categories.items():
        print(f"{category} : ${amount}")
    return categories
def highest_spending_category():
    categories=category_breakdown()
    if not categories:
        print("no data found")
    highest = max(categories,key=categories.get)
    print(f"\n Highest spending category :"
            f"{highest}:{categories[highest]:.2f}")
def smart_insights():
    categories=category_breakdown()
    if not categories:
        return
    total=sum(categories.values())
    highest=max(categories,key=categories.get)
    percentage=(categories[highest]/total)*100
    print("\n==========SMART INSIGHTS=========")
    print(
        f"You spend {percentage:.1f}%"
        f" of your money in {highest}"
    )
    if percentage>40:
        print(f"suggestion Try reducing {highest}  expenses by 10-15%")
    elif percentage>25:
        print(f"suggestion: Monitor your {highest} expenses regularly")
    else:
        print("Your expenses are balanced")