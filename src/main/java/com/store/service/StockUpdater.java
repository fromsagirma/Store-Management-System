package com.store.service;

public class StockUpdater extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Checking stock...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
    }
}
