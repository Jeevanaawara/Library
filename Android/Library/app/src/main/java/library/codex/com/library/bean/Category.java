package library.codex.com.library.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeevan.kumar on 03-Nov-17.
 */

public class Category {
    private Integer id;
    private String title;
    private List<Book> books = new ArrayList<>();

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
