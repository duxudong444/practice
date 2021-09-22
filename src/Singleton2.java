public class Singleton2 {
    //饿汉式单例类：在类初始化时，已经自行实例化。
    private static final Singleton2 instance = new Singleton2();
    private Singleton2(){
    }
    //饿汉式（推荐）
    public static Singleton2 getInstance(){
        return instance;
    }
    //枚举(推荐)
    enum Single{
        SINGLE;
        private Single(){
        }
    }
}
