package org.example;

// Dependency
// B, C depend on A
// D depend on B & C
class ThreadA extends Thread {

    Thread tb;
    Thread tc;
    public ThreadA(Thread tb, Thread tc) {
        this.tb = tb;
        this.tc = tc;
    }
    public void run() {
        System.out.println("Thread A starting ...");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread A exiting ...");
        synchronized (tb) {
            tb.notify();
        }
        synchronized (tc) {
            tc.notify();
        }
    }
}

class ThreadB extends Thread {

    public void run() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread B starting ...");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread B exiting ...");
        synchronized (this) {
            notify();;
        }
    }
}

class ThreadC extends Thread {

    public void run() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread C starting ...");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread C exiting ...");
        synchronized (this) {
            notify();;
        }
    }
}

class ThreadD extends Thread {
    Thread tb;
    Thread tc;

    public ThreadD (Thread tb, Thread tc) {
        this.tb = tb;
        this.tc = tc;
    }

    public void run() {
        synchronized (tb) {
            try {
                tb.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (tc) {
            try {
                tc.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread D starting ...");
        try {
            sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread D exiting ...");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadB tb = new ThreadB();
        ThreadC tc = new ThreadC();
        ThreadA ta = new ThreadA(tb, tc);
        ThreadD td = new ThreadD(tb, tc);

        tb.start();
        tc.start();
        ta.start();
        td.start();


    }
}