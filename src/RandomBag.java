import java.util.ArrayList;
import java.util.Random;

public class RandomBag implements IBag {

    private static final Random random = new Random();
    private final ArrayList<ISurprise> surprises;

    public RandomBag() {
        this.surprises = new ArrayList<>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.surprises.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while(!bagOfSurprises.isEmpty()) {
            this.surprises.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(this.surprises.isEmpty()) {
            return null;
        }
        int index = random.nextInt(this.surprises.size());
        ISurprise toReturn = this.surprises.get(index);
        this.surprises.remove(index);
        return toReturn;
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
