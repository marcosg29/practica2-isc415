package marcosg.pucmm.edu.controllers;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import marcosg.pucmm.edu.objects.User;
import marcosg.pucmm.edu.services.ApiService;
import marcosg.pucmm.edu.utils.AppRoles;
import marcosg.pucmm.edu.utils.BaseController;
import java.util.Collections;
import java.util.Set;

public class ApiController extends BaseController {

    private ApiService api = ApiService.getInstance();

    public ApiController(Javalin app) {
        super(app);
    }

    @Override
    public void applyRoutes() {

        app.config.accessManager((handler, ctx, permittedRoles) -> {
            final String user = ctx.sessionAttribute("username");

            if (user != null) {
                // find user
                User t = this.api.getUsers().stream()
                        .filter(u -> u.getUsername().equalsIgnoreCase(user))
                        .findAny()
                        .orElse(null);

                if (t != null) {
                    for (AppRoles r: t.getRoles()) {
                        if (permittedRoles.contains(r)) {
                            handler.handle(ctx);
                            break;
                        }
                    }
                }
                // check permissions
                // result
            } else { ctx.status(401).result("User not found."); }
        });

        /*
         * Routes
         * */
        app.routes(() -> path("/shop", () -> {

            path("/login", () -> {
                post("/:username/:password", ctx -> {
                    // Call login method
                    System.out.println("Username: " + ctx.pathParam("username", String.class).get());
                    System.out.println("Password: " + ctx.pathParam("password", String.class).get());
                });

                after(ctx -> ctx.header("Content-Type", "application/json"));
            });
            path("/products", () -> {
                before(ctx -> {
                    // Add session verification
                });

                get("/", ctx -> {
                    // Call list all products method
                });

                post("/create/:id/:name/:price", ctx -> {
                    // Call create product method

                }, Collections.singleton(AppRoles.ADMIN));

                delete("/:id", ctx -> {
                    // Call delete product method
                }, Collections.singleton(AppRoles.ADMIN));


                after(ctx -> ctx.header("Content-Type", "application/json"));
            });
            path("/cart", () -> {
                before(ctx -> {
                    // Add session verification
                });

                get("/", ctx -> {
                    // Call list cart item
                    ctx.result("this worked!");
                });

                delete("/:id", ctx -> {
                    // Call delete product from cart method
                });

                after(ctx -> ctx.header("Content-Type", "application/json"));
            });
        }));
    }
}
