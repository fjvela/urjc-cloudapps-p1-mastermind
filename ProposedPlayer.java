
public class ProposedPlayer {

    private int attempts;
    private ProposedCombination[] proposedCombination;

    public ProposedPlayer() {
        attempts = 0;
        proposedCombination = new ProposedCombination[Const.CODE_PEGS_LENGTH];
    }

    public void propose() {
        proposedCombination[attempts] = new ProposedCombination();
        proposedCombination[attempts].read();
        attempts++;
    }

    public ProposedCombination getLastProposedCombination() {
        return proposedCombination[attempts -1];
    }

    public void writeAttemps() {
        System.out.println(String.format("Attemps %d" , (attempts + 1)));
    }

    public void writeProposedCombinations() {
        for (int i = 0; i < attempts; i++) {
            proposedCombination[i].write();
        }
    }

    public boolean isWinner() {
        return false;

    }

    public boolean isLooser() {
        return attempts > Const.MAX_PLAYS;
    }

}