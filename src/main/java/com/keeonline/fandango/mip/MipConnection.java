package com.keeonline.fandango.mip;

public class MipConnection extends Thread {

    private static boolean isConnected = false;

    public static boolean isConnected() {
        return isConnected;
    }

    public static boolean notConnected() {
        return !isConnected;
    }

    public void run() {
        while (true) {
            System.out.println(this.getName() + ": MipConnection thread is running");
            try {
                //Wait for one sec so it doesn't print too fast
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
