public class WrapTypeDemo {
    public static void main(String[] args) throws InterruptedException {
        int userId = getUserId();
        System.out.println("userId  " + userId);
    }

    private static Integer getUserId() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
        //from database
        //from rpc
        //from http
        return 0;
    }
}
