public class MinionToy implements ISurprise {

    private static final String[] names = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
    private static int minionIndex = 0;
    private final String minionName;

    private MinionToy(String minionName) {
        this.minionName = minionName;
    }

    @Override
    public void enjoy() {
        System.out.printf("You got a minion named %s!%n", this.minionName);
    }

    @Override
    public String toString() {
        return "[Minion] name = " + this.minionName;
    }

    public static MinionToy generate() {
        String name = names[minionIndex];
        if(minionIndex == 5) {
            minionIndex = 0;
        } else {
            minionIndex++;
        }
        return new MinionToy(name);
    }
}
