package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        // Chain them
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        // Create test messages
        Message m1 = new Message(MessageType.COMPENSATION_CLAIM, "Flight delay compensation request", "user1@email.com");
        Message m2 = new Message(MessageType.CONTACT_REQUEST, "Need help with booking", "user2@email.com");
        Message m3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add dark mode to website", "user3@email.com");
        Message m4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "user4@email.com");

        // Send messages into the chain
        compensationHandler.handle(m1);
        compensationHandler.handle(m2);
        compensationHandler.handle(m3);
        compensationHandler.handle(m4);
    }
}

