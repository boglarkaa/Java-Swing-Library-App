package Books;
public class Book {
    private String title;
    private String author;
    private int pages;

    public Book() {
        this.title = "Undefined";
        this.author = "Undefined";
        this.pages = -1;
    }

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }




    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(title);
        str.append(" by ");
        str.append(author);
        str.append(", ");
        str.append(pages);
        str.append(" pages");
        return str.toString();
    }
}
