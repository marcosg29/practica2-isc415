package marcosg.pucmm.edu;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        String greet_message = "application is running!";

        // Instancing and running Jetty server w/ Javalin
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result(greet_message));
    }
}
