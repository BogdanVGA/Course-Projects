import java.util.Deque;
import java.util.LinkedList;

public class FifoBag implements IBag {

    private final Deque<ISurprise> surprises;

    public FifoBag() {
        this.surprises = new LinkedList<>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.surprises.offer(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()) {
            this.surprises.offer(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(this.surprises.isEmpty()) {
            return null;
        }
        return this.surprises.poll();
    }

    @Override
    public boolean isEmpty() {
        return this.surprises.isEmpty();
    }

    @Override
    public int size() {
        return this.surprises.size();
    }
}
