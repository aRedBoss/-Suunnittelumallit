package proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        // Users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Unprotected document
        RealDocument doc1 = new RealDocument("doc1", "Public content");
        library.addDocument(doc1);

        // Protected document
        library.addProtectedDocument("doc2", "Secret content");
        acs.allow("doc2", "Alice"); // Only Alice can access

        // Access attempt
        try {
            System.out.println("Alice reads doc2: " + library.getDocument("doc2").getContent(alice));
            System.out.println("Bob reads doc2: " + library.getDocument("doc2").getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}

