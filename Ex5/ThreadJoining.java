public class ThreadJoining implements Runnable {
    int value;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            value++;

        }
        System.out.println(value);
    }
}
