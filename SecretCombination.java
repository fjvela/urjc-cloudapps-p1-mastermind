import java.util.Arrays;
import java.util.Random;

public class SecretCombination extends Combination {


    private Random random;

    public SecretCombination() {

        super();
        random = new Random();

        for (int i = 0; i < combination.length; i++) {
            combination[i] = randomEnum(Color.class);
        }
    }

    public Result calculateResult(ProposedCombination proposedCombination) {
        Color colorAtPosition;
        int damages = 0;
        int deads = 0;

        for (int i = 0; i < combination.length; i++) {
            colorAtPosition = combination[i];
            if (proposedCombination.contains(colorAtPosition)) {
                damages++;
            }
            if (proposedCombination.contains(colorAtPosition, i)) {
                deads++;
            }
        }

        return new Result(damages, deads);

    }

    public void write() {
        char[] secret = new char[combination.length];
        Arrays.fill(secret, '*');

        System.out.println(String.format("Secret combination %s",  new String(secret)));

    }

    private <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}