// Singleton Design Pattern
// https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples

public class BagFactory implements IBagFactory {

    private BagFactory() {
    }

    private static class SingletonHelper {
        private static final BagFactory INSTANCE = new BagFactory();
    }

    public static BagFactory getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public IBag makeBag(String type) {
        return switch (type) {
            case "RANDOM" -> new RandomBag();
            case "FIFO" -> new FifoBag();
            case "LIFO" -> new LifoBag();
            default -> {
                System.out.println("Incorrect type");
                yield null;
            }
        };
    }
}
