import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static int state = 0;

    static class ThreadA extends Thread{
        @Override
        public void run(){

           for(int i=1; i<10;){
               try {
                   lock.lock();
                   if (state % 2 == 0) {
                       System.out.println("A");
                       i++;
                       state++;
                   }
               } finally {
                   lock.unlock();
               }

           }

       }
    }
    static class ThreadB extends Thread{
        @Override
        public void run(){

            for(int i=1; i<10;){
                try {
                    lock.lock();
                    if (state % 2 == 1) {
                        System.out.println("B");
                        i++;
                        state++;
                    }
                }finally {
                    lock.unlock();
                }

            }

        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}
