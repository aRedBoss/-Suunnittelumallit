package chain_of_responsibility;

public class ContactRequestHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void process(Message message) {
        System.out.println("Contact Request from " + message.getSenderEmail() +
                " forwarded to support team.");
    }
}

