class App {

    public static void main(String[] args) {
        GreeterTask greet = new GreeterTask();
        Thread LehmanThread1 = new Thread(greet);
        Thread LehmanThread2 = new Thread(greet);
        LehmanThread1.setName("Lehman-Thread-1");
        LehmanThread2.setName("Lehman-Thread-2");
        LehmanThread1.start();

        LehmanThread2.start();

        try {
            LehmanThread1.join();
            LehmanThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exercise 2

        MyThread practiceT = new MyThread();
        Thread statusThread = new Thread(practiceT);
        System.out.println(statusThread.getState());
        statusThread.start();
        System.out.println(statusThread.getState());

        // Exersose 3
        BankAccount acc = new BankAccount();
        Thread Husband = new Thread(acc);
        Thread Wife = new Thread(acc);
        Husband.start();
        Wife.start();

        ThreadJoining t1 = new ThreadJoining();
        Thread t2 = new Thread(t1);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}