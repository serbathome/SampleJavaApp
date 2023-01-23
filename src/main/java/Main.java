public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        while(true) {
            System.out.print('.');
            Thread.sleep(1000);
        }
    }
}
