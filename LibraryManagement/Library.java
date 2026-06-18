package LibraryManagement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books= new ArrayList<>();
    ArrayList<User> users= new ArrayList<>();
    ArrayList<Transaction> transactions=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added successfully");
    }
    public void registerUser(User user){
        users.add(user);
        System.out.println("User registered successfully");
    }
    public void displayBooks(){
        for(Book b:books){
            System.out.println(b);
        }
    }
    public void searchBook(String KeyWord){
        for(Book b:books){
            if(b.getTitle().toLowerCase().contains(KeyWord.toLowerCase())||b.getAuthor().toLowerCase().contains(KeyWord.toLowerCase())){
                System.out.println(b);
            }
        }
    }
    public void issueBook(int bookId,int userId){
        for(Book b:books){
            if(b.getBookId()==bookId && !b.isIssued()){
                b.setIssued(true);
                LocalDate issueDate=LocalDate.now();
                LocalDate dueDate =LocalDate.now().plusDays(14);
                transactions.add(new Transaction(bookId, userId, issueDate, dueDate));
                System.out.println("Book issued successfully");
                System.out.println("Due date : "+dueDate);
                return;
            }
        }
        System.out.println("book not available");
    }
    public void returnBook(int bookID){
        for(Book b :books){
            if(b.getBookId()==bookID && b.isIssued()){
                b.setIssued(false);
                for(Transaction t: transactions){
                    if(t.bookId==bookID){
                        LocalDate returnDate=LocalDate.now();
                        long daysLate=ChronoUnit.DAYS.between(t.dueDate, returnDate);
                        if(daysLate>0){
                            double fine=daysLate*5;
                            System.out.println("Late fine= $"+fine);
                        }
                        System.out.println("Book return successfully");
                    }
                    return;
                }
            }
        }
    }
}
