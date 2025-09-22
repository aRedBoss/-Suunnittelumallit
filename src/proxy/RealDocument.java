package proxy;

import java.time.LocalDate;

public class RealDocument implements Document {
    private String id;
    private String creationDate;
    private String content;

    public RealDocument(String id, String content) {
        this.id = id;
        this.content = content;
        this.creationDate = LocalDate.now().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}

