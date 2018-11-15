package Problem2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Textbook implements Serializable {
    private String isbn, title;
    private String authors;

    public Textbook(){

    }

    public Textbook(String isbn, String title, String authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return authors + " '" + title + "'. " + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return Objects.equals(isbn, textbook.isbn) &&
                Objects.equals(title, textbook.title) &&
                Objects.equals(authors, textbook.authors);
    }
}
