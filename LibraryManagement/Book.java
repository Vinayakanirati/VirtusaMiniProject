package LibraryManagement;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean issued;
    public Book(int bookID,String title,String author){
        this.bookID=bookID;
        this.author=author;
        this.title=title;
    }
    public int getBookId(){
        return this.bookID;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public boolean isIssued(){
        return this.issued;
    }
    public void setIssued(boolean val){
        this.issued=val;
    }
    @Override
    public String toString(){
        return bookID+"|"+title+"|"+author+"|"+(issued?"Issued":"Available");
    }    

}
