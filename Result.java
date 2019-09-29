public class Result {
    private int deads;
    private int damages;

    public Result() {
        deads = 0;
        damages = 0;
    }

    public Result(int damages, int deads) {
        this.damages = damages;
        this.deads = deads;
    }

    public void write() {
        System.out.println(String.format("%s = %d %s = %d", "Deads", deads, "damaged", damages));
    }

    public int getDeads() {
        return deads;
    }

    public int getDamages() {
        return damages;
    }

    public boolean isWinner() {
        return deads == Const.CODE_PEGS_LENGTH;
    }
}