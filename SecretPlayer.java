
public class SecretPlayer {
    private ProposedPlayer proposedPlayer;
    private SecretCombination secretCombination;

    public SecretPlayer(ProposedPlayer proposedPlayer) {
        this.proposedPlayer = proposedPlayer;

    }

    public void prepare() {
        secretCombination = new SecretCombination();
    }

    public void answer() {
        ProposedCombination proposedCombination = proposedPlayer.getLastProposedCombination();
        proposedCombination.set(secretCombination.calculateResult(proposedCombination));
    }

    public void write() {
        if (secretCombination != null) {
            secretCombination.write();
        }
    }
}