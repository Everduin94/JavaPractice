package model;

/**
 * Created by everduin on 12/22/2016.
 */
public class Message {
    private String title;
    private String contents;

    public Message(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
