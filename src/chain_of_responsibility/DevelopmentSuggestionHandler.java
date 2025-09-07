package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void process(Message message) {
        System.out.println("Development Suggestion logged: " + message.getContent());
    }
}

