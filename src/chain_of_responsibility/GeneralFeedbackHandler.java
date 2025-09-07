package chain_of_responsibility;

public class GeneralFeedbackHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void process(Message message) {
        System.out.println("General Feedback received: " + message.getContent());
    }
}

