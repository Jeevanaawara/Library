package library.codex.com.library.bean;

/**
 * Created by jeevan.kumar on 03-Nov-17.
 */

public class Book {
    private Integer id;
    private String title;

    private Book(){

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
}
