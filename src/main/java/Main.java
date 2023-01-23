public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        while(true) {
            System.out.print('.');
            // make thread sleep for 1 second
            Thread.sleep(1000);
        }
    }
}
