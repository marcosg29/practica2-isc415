package marcosg.pucmm.edu.controllers;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
import marcosg.pucmm.edu.services.ApiServices;
import marcosg.pucmm.edu.utils.BaseController;


public class ApiController extends BaseController {

    private ApiServices api = ApiServices.getInstance();

    public ApiController(Javalin app) {
        super(app);
    }

    @Override
    public void applyRoutes() {
        /*
         * Routes
         * */
        app.routes(() -> path("/shop", () -> {

            path("/login", () -> {
                after(ctx -> ctx.header("Content-Type", "application/json"));

                post("/:username/:password", ctx -> {
                    System.out.println("Username: " + ctx.pathParam("username", String.class).get());
                    System.out.println("Password: " + ctx.pathParam("password", String.class).get());
                });
            });
            path("/products", () -> {
                after(ctx -> ctx.header("Content-Type", "application/json"));
            });
            path("/cart", () -> {
                after(ctx -> ctx.header("Content-Type", "application/json"));
            });
        }));
    }
}
