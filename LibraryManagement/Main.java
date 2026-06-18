package LibraryManagement;
import java.util.Scanner;;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library=new Library();
        while(true){
            System.out.println("\n=============MENU=================");
            System.out.println("\n1.Add book\n2.Register user\n3.DisplayBooks\n4.Search book \n5.Issue book\n6. Return Book\n7.exit");
            int choice =sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("BookId : ");
                    int bookID =sc.nextInt();
                    sc.nextLine();
                    System.out.println("Title : ");
                    String title =sc.nextLine();
                    System.out.println("Author : ");
                    String author =sc.nextLine();
                    library.addBook(new Book(bookID,title,author));
                    break;
                case 2:
                    System.out.println("User ID : ");
                    int userId=sc.nextInt();
                    sc.nextLine();
                    System.out.println("NAme : ");
                    String name =sc.nextLine();
                    library.registerUser(new User(userId, name));
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Title / Author");
                    String keyword=sc.nextLine();
                    library.searchBook(keyword);
                    break;
                case 5:
                    System.out.println("BookId :" );
                    int issuebookID =sc.nextInt();
                    System.out.println("UserId : ");
                    int issueuserId=sc.nextInt();
                    library.issueBook(issuebookID, issueuserId);
                    break;
                case 6:
                    System.out.println("BookId : ");
                    int returnBookId  =sc.nextInt();
                    library.returnBook(returnBookId);

                default:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
