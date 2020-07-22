package singleton;

/*
This design pattern is useful where only one instance of a class is needed, Like Database connection, cache instance, driver etc
*/

// It is a eager initialization
// As soon as class is created, reference variable will be initiated.
class SingletonClassEager{
    private static SingletonClassEager reference = new SingletonClassEager();

    private SingletonClassEager(){};

    public static SingletonClassEager getReference(){
        return reference;
    }
}

// It is a lazy initialization
// reference will be created only when get reference is called.
class SingletonClassLazy{

    // private to disable access from outside class
    // static so that it can be accessed by a static function
    private static SingletonClassLazy reference;

    // private to disable object creation from outside
    private SingletonClassLazy(){};

    // public and static so that it can be accessed outside as class level.
    public static SingletonClassLazy getReference(){
        if(reference == null){
            reference = new SingletonClassLazy();
        }
        return reference;
    }
}

// It is a thread safe initialization
// multiple thread may call getReference initially at the same time which may result in multiple objects creation
// getReference is hence synchronized so that only one thread may access it at a time.
// reference will be created only when get reference is called.
// in other variation instead of putting whole method has sync, we can simply put the wite part in synchronized block.
class SingletonClassThreaded{
    private static SingletonClassThreaded reference;

    private SingletonClassThreaded(){};

    public static synchronized SingletonClassThreaded getReference(){
        if(reference == null){
            reference = new SingletonClassThreaded();
        }
        return reference;
    }
}


public class Singleton {
    public static void main(String[] args){

        // Eager implementation
        SingletonClassEager singletonClassEager = SingletonClassEager.getReference();
        System.out.println(singletonClassEager.hashCode());
        SingletonClassEager singletonClassEager2 = SingletonClassEager.getReference();
        System.out.println(singletonClassEager2.hashCode());

        // Lazy implementation
        SingletonClassLazy singletonClassLazy = SingletonClassLazy.getReference();
        System.out.println(singletonClassLazy.hashCode());
        SingletonClassLazy singletonClassLazy2 = SingletonClassLazy.getReference();
        System.out.println(singletonClassLazy2.hashCode());

        // Threaded implementation
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                SingletonClassThreaded singletonClassThreaded = SingletonClassThreaded.getReference();
                System.out.println(singletonClassThreaded.hashCode());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                SingletonClassThreaded singletonClassThreaded2 = SingletonClassThreaded.getReference();
                System.out.println(singletonClassThreaded2.hashCode());
            }
        });
        t1.start();
        t2.start();
    }
}
