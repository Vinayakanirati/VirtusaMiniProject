import matplotlib.pyplot as plt
from storage import load_expenses
def generate_pie_chart():
    expenses=load_expenses()
    categories={}
    for expense in expenses:
        category=expense["category"]
        if category not in categories:
            categories[category]=0
        categories[category]+=int(expense["amount"])
    if not categories:
        print("No data available")
        return
    labels=list(categories.keys())
    amounts=list(categories.values())
    plt.figure(figsize=(7,7))
    plt.pie(
        amounts,
        labels=labels,
        autopct="%1.1f%%",
        startangle=90
    )
    plt.title("Expenses distribution by category")
    plt.show()

