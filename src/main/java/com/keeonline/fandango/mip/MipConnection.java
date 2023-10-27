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
        int i = 0;
        while (true) {
            System.out.println(this.getName() + ": MipConnection thread is running");
            try {
                //Wait for one sec so it doesn't print too fast
                Thread.sleep(5000);
                ++i;
                if (i == 20){
                    isConnected = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
