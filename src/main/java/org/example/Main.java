package org.example;

// Dependency
// B, C independently depend on A
// D depend on B & C
class MyThread extends Thread {
    Thread[] threads;
    public MyThread(String name, Thread... threads ) {
        this.setName(name);
        this.threads = threads;
    }

    public void run() {
        if (threads!=null) {
            for (Thread t:threads) {
                try {
                    t.join();
                    System.out.println(this.getName()+" joining "+t.getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(this.getName()+" starting ...");
        System.out.println(this.getName()+" exiting ...");
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread ta = new MyThread("A", (Thread[])null);
        MyThread tb = new MyThread("B", ta);
        MyThread tc = new MyThread("C", ta);
        MyThread td = new MyThread("D", tb, tc);

        td.start();
        tb.start();
        tc.start();
        ta.start();
    }
}
