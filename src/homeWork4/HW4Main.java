package homeWork4;

public class HW4Main {
    static Object mon = new Object();
    static String currentLetter = "A";

    public static void main(String[] args) {
        new Thread(() -> {
            try{
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while(currentLetter != "A"){
                            mon.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "B";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while(currentLetter != "B"){
                            mon.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "C";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while(currentLetter != "C"){
                            mon.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = "A";
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
