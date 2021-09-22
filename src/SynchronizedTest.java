public class SynchronizedTest implements Runnable{
    //首先是线程的名字和锁
    private String name;
    private Object lock;
    //构造函数
    public  SynchronizedTest(String name, Object lock){
        this.name = name;
        this.lock = lock;
    }
    //实现Runnable接口
    @Override
    public void run() {
        //定义输出的次数
        int count = 10;
        while (count > 0){
            //加锁实现交替输出
            synchronized (lock){

                    System.out.println(name);
                    count--;
                    lock.notify();
                    //try catch 捕获异常，if判断停止线程，else等待下一个线程
                    try {
                        if(count == 0){
                            lock.notifyAll();
                        }else {
                            lock.wait();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }



            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        SynchronizedTest a = new SynchronizedTest("A", object);
        SynchronizedTest b = new SynchronizedTest("B", object);

        new Thread(a).start();
        new Thread(b).start();
    }
}
