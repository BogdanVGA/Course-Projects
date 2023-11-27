import java.util.Random;

public class Candies implements ISurprise {

    private final static Random random = new Random();
    private final int candyNo;
    private final String candyType;

    private Candies(int num, String type) {
        this.candyNo = num;
        this.candyType = type;
    }

    @Override
    public void enjoy() {
        System.out.printf("You received %d %s candies.%n",
                this.candyNo, this.candyType);
    }

    @Override
    public String toString() {
        return "[Candies] number = " + this.candyNo +
                ", type = " + this.candyType;
    }

    public static Candies generate() {
        String[] types = {"chocolate", "jelly", "fruits", "vanilla"};
        int maxCandy = 100;

        int candyNo = random.nextInt(0, maxCandy);
        int candyTypeIndex = random.nextInt(0,types.length - 1);
        String candyType = types[candyTypeIndex];

        return new Candies(candyNo, candyType);
    }
}
