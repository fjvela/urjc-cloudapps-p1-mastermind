import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProposedCombination extends Combination {
    private Result result;

    public ProposedCombination() {
        super();
    }

    public void read() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean readed = false;

        String line;
        String[] colorItems;
        while (!readed) {
            
            System.out.print("Propose a combination: ");
            try {
                line = input.readLine();
                colorItems = line.split(" ");
                ParseColorItemsToCombination(colorItems);
                readed = true;
            } catch (Exception ex) {
                System.out.println(
                    String.format("The color isn't valid, please enter a valid color: %s ",  
                        String.join(", ", getNamesFromEnum(Color.class))));
            }
        }
    }

    public boolean contains(Color color, int position) {
        return position >= 0 && position < combination.length && combination[position] == color;
    }

    public boolean contains(Color color) {
        return Arrays.stream(combination).anyMatch(color::equals);
    }

    public void set(Result result) {
        this.result = result;
    }

    public boolean isWinner() {
        return result.isWinner();

    }

    public void write() {
        String[] colorNames = Arrays.stream(combination).map(Enum::name).toArray(String[]::new);
        System.out.println(String.format("%s --> %d damages %d deads", String.join(", ", colorNames),
                result.getDamages(), result.getDeads()));
    }

    private String[] getNamesFromEnum(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    private void ParseColorItemsToCombination(String[] colorItems) {
        if (colorItems.length == combination.length) {
            for (int i = 0; i < colorItems.length; i++) {
                combination[i] =  Color.valueOf(colorItems[i]);
            }
        }else {
            System.out.println("Invalid combination, it must be 'Yellow Red White Blue'");
        }
    }
}