import java.util.Random;

public final class GatherSurprises {

    private static final Random random = new Random();

    // Dummy constructor, never used
    private GatherSurprises() {
    }

    // Returns one surprise
    public static ISurprise gather() {
        int surpriseType = random.nextInt(3);
        return switch (surpriseType) {
            case 1 -> FortuneCookie.generate();
            case 2 -> Candies.generate();
            default -> MinionToy.generate();
        };
    }

    // Returns a list of surprises
    public static ISurprise[] gather(int surpriseNumber) {
        ISurprise[] surprises = new ISurprise[surpriseNumber];
        for(int i = 0; i < surprises.length; i++) {
            surprises[i] = gather();
        }
        return surprises;
    }
}
