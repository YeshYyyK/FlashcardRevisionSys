import java.util.Random;
public class Test {
    public static void main(String[] args) {
        QueueInterface<String> test = new LinkedQueue<>();
        Random getRandom = new Random();
        //testing for random logic needed in quiz generation
        int Min = 5;
        int Max = 10;
        int rand = Min + (int)(Math.random() * ((Max - Min) + 1));
        System.out.println(rand);

    }
}
