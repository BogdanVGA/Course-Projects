public class Main {

    public static void main(String[] args) {

        System.out.println("SURPRISE TEST:");
        FortuneCookie cookie = FortuneCookie.generate();
        Candies candies = Candies.generate();
        MinionToy toyOne = MinionToy.generate();

        cookie.enjoy();
        cookie.newMethod();
        System.out.println(cookie);
        candies.enjoy();
        System.out.println(candies);
        toyOne.enjoy();
        System.out.println(toyOne);

        System.out.println("-".repeat(50));
        System.out.println("BAG TEST");
        RandomBag randomBag = new RandomBag();
        FifoBag fifoBag = new FifoBag();
        LifoBag lifoBag = new LifoBag();
        randomBag.put(cookie);
        randomBag.put(candies);
        randomBag.put(toyOne);
        fifoBag.put(cookie);
        fifoBag.put(candies);
        fifoBag.put(toyOne);
        lifoBag.put(cookie);
        lifoBag.put(candies);
        lifoBag.put(toyOne);

        System.out.println("RANDOM BAG OUTPUT:");
        while(!randomBag.isEmpty()) {
            randomBag.takeOut().enjoy();
        }
        System.out.println("FIFO BAG OUTPUT:");
        while(!fifoBag.isEmpty()) {
            fifoBag.takeOut().enjoy();
        }
        System.out.println("LIFO BAG OUTPUT:");
        while(!lifoBag.isEmpty()) {
            lifoBag.takeOut().enjoy();
        }

        System.out.println("-".repeat(50));
        System.out.println("BAG FACTORY TEST");

        ISurprise[] surprises = GatherSurprises.gather(5);
        System.out.println("Return ISurprise[] array from GatherSurprises.gather(int):");
        for (ISurprise surprise : surprises) {
            surprise.enjoy();
        }

        BagFactory factory = BagFactory.getInstance();
        LifoBag lifo = (LifoBag) factory.makeBag("LIFO");
        FifoBag fifo = (FifoBag) factory.makeBag("FIFO");
        RandomBag random = (RandomBag) factory.makeBag("RANDOM");

        for(ISurprise surprise : surprises) {
            lifo.put(surprise);
            fifo.put(surprise);
            random.put(surprise);
        }

        System.out.println("-".repeat(50));
        System.out.println("LIFO Bag:");
        while(!lifo.isEmpty()) {
            lifo.takeOut().enjoy();
        }

        System.out.println("-".repeat(50));
        System.out.println("RANDOM Bag:");
        while(!random.isEmpty()) {
            random.takeOut().enjoy();
        }

        System.out.println("-".repeat(50));
        System.out.println("FIFO Bag:");
        while(!fifo.isEmpty()) {
            fifo.takeOut().enjoy();
        }

        System.out.println("-".repeat(50));
        System.out.println("GIVE SURPRISE AND APPLAUSE TEST");
        GiveSurpriseAndApplause giveSurprises = new GiveSurpriseAndApplause("LIFO", 2);
        surprises = GatherSurprises.gather(6);
        System.out.println("Return ISurprise[] array from GatherSurprises.gather(int):");
        for (ISurprise surprise : surprises) {
            surprise.enjoy();
        }
        for(ISurprise surprise : surprises) {
            fifo.put(surprise);
        }
        giveSurprises.put(fifo);
        System.out.println("'GIVE SURPRISE AND APPLAUSE' OUTPUT:");
        giveSurprises.giveAll();
    }
}
