import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {

    private final IBag bag;
    private final int waitTime;

    public AbstractGiveSurprises(String bagType, int waitTime) {
        BagFactory factory = BagFactory.getInstance();
        this.bag = factory.makeBag(bagType);
        this.waitTime = waitTime;
    }

    public void put(ISurprise newSurprise) {
        this.bag.put(newSurprise);
    }

    public void put(IBag surprises) {
        this.bag.put(surprises);
    }

    public void give() {
        this.bag.takeOut().enjoy();
        giveWithPassion();
    }

    public void giveAll() {
        while(!this.bag.isEmpty()) {
            this.bag.takeOut().enjoy();
            try {
                TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
            } catch (InterruptedException e) {
                System.out.println("waitTime: Something went wrong");
            }
        }
        giveWithPassion();
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    abstract void giveWithPassion();
}
