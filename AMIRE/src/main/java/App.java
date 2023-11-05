import util.DatabaseConfiguration;

public class App {
    public static void main(String[] args) {

        try {
            DatabaseConfiguration.getConnection();
            System.out.println("Connection to database successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }
}
