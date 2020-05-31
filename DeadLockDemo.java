package thread;

/**
 * Created on 2020/5/31.
 * 死锁演示
 *
 * @author etlRlks
 */
class LockDemo implements Runnable {

    private boolean flag;

    public LockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA) {
                System.out.println(Thread.currentThread().getName() + "if....ALock");
                synchronized (MyLock.objB) {
                    System.out.println(Thread.currentThread().getName() + "if....BLock");
                }
            }
        } else {
            synchronized (MyLock.objB) {
                System.out.println(Thread.currentThread().getName() + "else....BLock");
                synchronized (MyLock.objA) {
                    System.out.println(Thread.currentThread().getName() + "else....ALock");
                }
            }
        }
    }
}

class MyLock {
    public static final Object objA = new Object();
    public static final Object objB = new Object();

}

public class DeadLockDemo {
    /*
    两个线程， 你持有我的锁， 我持有你的锁
     */

    public static void main(String[] args) {
        LockDemo ld1 = new LockDemo(true);
        LockDemo ld2 = new LockDemo(false);

        Thread t1 = new Thread(ld1);
        Thread t2 = new Thread(ld2);

        t1.start();
        t2.start();
    }

}
