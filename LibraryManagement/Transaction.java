package LibraryManagement;
import java.time.LocalDate;
public class Transaction {
    int bookId;
    int userId;
    LocalDate issueDate;
    LocalDate dueDate;
    public Transaction(int bookID,int userId,LocalDate issueDate,LocalDate dueDate){
        this.bookId=bookID;
        this.issueDate=issueDate;
        this.dueDate=dueDate;
        this.userId=userId;
    }
}
