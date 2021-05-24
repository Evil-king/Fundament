package com.hwq.fundament.test;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThraead extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            new ReaderThraead().start();
            number = 42;
            ready = true;
        }
    }
}
