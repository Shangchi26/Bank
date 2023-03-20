package bank.t2208a1;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    public static Long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();

    public static Long getNewID(){
        Long result;
        lock.lock();
        try {
            result = ++id;
        } finally {
            lock.unlock();
        }
        return result;
    }

    private IdGenerate() {

    }
}
