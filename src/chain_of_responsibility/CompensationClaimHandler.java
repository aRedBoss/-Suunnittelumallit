package chain_of_responsibility;

public class CompensationClaimHandler extends Handler {
    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void process(Message message) {
        System.out.println("Compensation Claim from " + message.getSenderEmail() +
                " reviewed. Decision: APPROVED/REJECTED.");
    }
}

