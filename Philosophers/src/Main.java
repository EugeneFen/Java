import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    public static void main(String[] args)
    {
        ReentrantLock locker = new ReentrantLock();
        Table tab = new Table();

        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new Philosophers(i, tab));
            t.setName("Philosopher "+ i);
            t.start();
        }
        System.out.println("Главный поток завершён...");
    }
}