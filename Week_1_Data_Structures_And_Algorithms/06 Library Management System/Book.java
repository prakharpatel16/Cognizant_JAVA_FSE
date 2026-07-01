public class Book {
    private int id;
    private String name;
    private String writer;

    public Book(int i, String n, String w) {
        id = i;
        name = n;
        writer = w;
    }

    public int getBookId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public String getAuthor() {
        return writer;
    }

    @Override
    public String toString() {
        return "Book{" +
               "bookId=" + id +
               ", title='" + name + '\'' +
               ", author='" + writer + '\'' +
               '}';
    }
}