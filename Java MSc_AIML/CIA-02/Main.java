class Book{
    int bookId;
    String title;
    String author;
    boolean borrowed;
    Book(int bookId, String title, String author){ //constructer for setting and retrieving these attributes
        if(bookId < 1){
            System.out.println("Invalid Book ID");
            System.exit(1);
        }
        else{
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.borrowed = false; //when new book is entered, it is not borrowed default
        }
    }
    public void retrieving(){ //display method for retrieving these attributes 
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
    }
    public void borrow(boolean borrowed){ //methods for borrowing and returning books
        this.borrowed = borrowed;
    }
    public void Status(){ //track the availability of each book
        System.out.println("Borrowed: " + this.borrowed);        
    }
    public void lateFine(int days){ // overdue fines for late returns
        System.out.println("Late Fine: " + days*10 + "$");
    } 
}
class ReferenceBook extends Book{
    int edition;
    ReferenceBook(int bookId, String title, String author, int edition){
        super(bookId, title, author); //using super keyword to call parent class construstr
        if(edition < 1){
            System.out.println("Invalid edition");
            System.exit(1);
        }
        else{
            this.edition = edition;
        }
    }
    void display(){
        super.retrieving();
        System.out.println("Edition: " + this.edition);
    }
}
class FictionBook extends Book{
    String genre;
    FictionBook(int bookId, String title, String author, String genre){
        super(bookId, title, author);
        this.genre = genre;
    }
    void display(){
        super.retrieving();
        System.out.println("Genre: " + this.genre);
    }
}
class Periodical extends ReferenceBook{
    String issueFrequency;
    Periodical(int bookId, String title, String author, int edition, String issueFrequency){
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }
    @Override
    void display(){ //methods to display detailed information for periodicals. 
        super.display();
        System.out.println("IssueFrequency: " + this.issueFrequency);
    }
}

public class Main {
    public static void main(String[] args) {
        ReferenceBook rBook = new ReferenceBook(1, "Book1", "Author1", 1);
        FictionBook fBook = new FictionBook(2, "Book2", "Author2", "x");
        rBook.display();
        fBook.display();
        fBook.borrow(true);
        fBook.Status();
        Periodical pBook = new Periodical(3, "Book3", "Author3", 3, "weekly");
        pBook.display();
        pBook.lateFine(2);
        ReferenceBook invalidBook = new ReferenceBook(-1,"invalidBook","xyz",-88); //Data Validation
    }
}
