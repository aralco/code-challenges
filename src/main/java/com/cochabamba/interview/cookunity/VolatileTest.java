// Java Program to demonstrate the
// use of Volatile Keyword in Java

public class VolatileTest {
    private static volatile int MY_INT = 0;

    public static void main(String[] args)
    {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override public void run()
        {
            int local_value = MY_INT;
            while (local_value < 5) {
              //  System.out.println("Valor:"+MY_INT);
                if (local_value != MY_INT) {
                    System.out.println("Got Change for MY_INT : "+MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override public void run()
        {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("Incrementing MY_INT to "+(local_value + 1));
//                synchronized (VolatileTest.class) {
                    MY_INT = ++local_value;
//                }
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
