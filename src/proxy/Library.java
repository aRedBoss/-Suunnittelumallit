package proxy;

import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(Document doc) {
        documents.put(doc.getId(), doc);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }

    public void addProtectedDocument(String id, String content) {
        RealDocument realDoc = new RealDocument(id, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }
}

