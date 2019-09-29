public class Mastermind {

    private SecretPlayer secretPlayer;
    private ProposedPlayer proposedPlayer;

    public Mastermind() {
        proposedPlayer = new ProposedPlayer();
        secretPlayer = new SecretPlayer(proposedPlayer);

    }

    public void play() {
        secretPlayer.prepare();
        System.out.println("----- MASTERMIND -----");
        secretPlayer.write();

        while (!proposedPlayer.isWinner() && !proposedPlayer.isLooser()) {
            doPlay();
   
        }
    }

    private void doPlay() {
        proposedPlayer.propose();
        secretPlayer.answer();
        proposedPlayer.writeAttemps();
        proposedPlayer.writeProposedCombinations();
    }
}