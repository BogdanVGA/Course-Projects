import java.util.Deque;
import java.util.LinkedList;

public class LifoBag implements IBag {

    private final Deque<ISurprise> surprises;

    public LifoBag() {
        this.surprises = new LinkedList<>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.surprises.push(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()) {
            this.surprises.push(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(this.surprises.isEmpty()) {
            return null;
        }
        return this.surprises.pop();
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
