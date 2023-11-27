import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FortuneCookie implements ISurprise {

    private final static Random random = new Random();
    private final String message;

    private FortuneCookie(String message) {
        this.message = message;
    }

    @Override
    public void enjoy() {
        System.out.println("You got a fortune cookie!");
        System.out.printf("\"%s\"%n", this.message);
    }

    @Override
    public String toString() {
        return "[FortuneCookie] message = " + this.message;
    }

    public static FortuneCookie generate() {

        ArrayList<String> messages = new ArrayList<>();
        String filePath = "./FortuneMsg.txt";
        File sourceFile = new File(filePath);
        try {
            Scanner fileIn = new Scanner(sourceFile);
            while (fileIn.hasNextLine()) {
                messages.add(fileIn.nextLine());
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            return new FortuneCookie("You're out of luck: file not found.");
        }

        int choiceIndex = random.nextInt(messages.size());
        String chosenMessage = messages.get(choiceIndex);

        return new FortuneCookie(chosenMessage);
    }
}
