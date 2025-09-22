package proxy;

public class DocumentProxy implements Document {
    private RealDocument realDocument;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();
        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}

