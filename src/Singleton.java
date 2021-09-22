public class Singleton {
    //懒汉式在第一次调用时实例化
    private static Singleton intance = null;
    private Singleton(){
    }
    //适用于单线程环境（不推荐）
    //如果两个线程同时运行到判断 instance 是否为 null 的 if 语句，
    //并且 instance 的确没有被创建时，那么两个线程都会创建一个实例，
    //此时类型 Singleton1 就不再满足单例模式的要求了。
    public static Singleton getInstanceA(){
        if(intance == null){
            return intance = new Singleton();
        }
        return intance;

    }
    //多线程环境下，加锁，但效率不高（不推荐）
    //但每次调用 getInstanceB () 方法时都被 synchronized 关键字锁住了，会引起线程阻塞，影响程序的性能。
    public static synchronized Singleton getInstanceB(){
        if(intance == null){
            return intance = new Singleton();
        }
        return intance;
    }
    //双重检验加锁，先判断实例是否存在，如果不存在，再进行加锁处理(推荐）
    //不让线程每次调用 getInstanceC () 方法时都加锁，而只是在实例未被创建时再加锁，在加锁处理里面还需要判断一次实例是否已存在。
    public static Singleton getInstanceC(){
        if(intance == null){
            synchronized (Singleton.class){
                if(intance == null){
                    intance = new Singleton();
                }
            }
        }
        return intance;
    }
    //静态内部类方式(推荐)
    //1 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
    //2 由于在调用 StaticSingleton.getInstance () 的时候，才会对单例进行初始化，而且通过反射，是不能从外部类获取内部类的属性的；
    //3 由于静态内部类的特性，只有在其被第一次引用的时候才会被加载
//    public static Singleton getInstance(){
//        return StaticSingletonHold.instance;
//    }
//    private static class StaticSingletonHold{
//        private static final Singleton instance = new Singleton();
//    }
    public static Singleton getInstance(){
        return staticClass.instance;
    }
    private static class staticClass{
        private static final Singleton instance = new Singleton();
    }

}
