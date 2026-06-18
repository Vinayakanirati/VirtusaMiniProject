import expense_manager as manager 
import charts 
import analytics
import storage 
storage.init_file()
print("Hello welcome to smart expense tracker !")
while True:
    print("\n","="*10,"MENU","="*10)
    print()
    print("1. Add Expenses \n""2. View Expenses \n","3. Monthly summary\n","4.Category breakdowns \n 5. Charts \n 6. Smart Insights \n 7. Exit"
    )
    choice=int(input("enter your choice: "))
    if choice==1:
        manager.add_expense()
    elif choice==2:
        manager.view_expenses()
    elif choice==3:
        month=int(input("Enter month(1-12): "))
        year=int(input("Enter Year: "))
        analytics.monthly_summary(month,year)
    elif choice==4:
        categories=analytics.category_breakdown()
    elif choice==5:
        charts.generate_pie_chart()
    elif choice==6:
        analytics.smart_insights()
    else:
        print("Thank you")
        break


