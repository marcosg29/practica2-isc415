package marcosg.pucmm.edu;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import marcosg.pucmm.edu.controllers.ApiController;
import marcosg.pucmm.edu.objects.User;
import marcosg.pucmm.edu.utils.AppRoles;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String greet_message = "application is running!";
        int port = 7000;
        // Instancing and running Jetty server w/ Javalin
        Javalin app = Javalin.create(config ->{
//            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
            config.enableCorsForAllOrigins();
            config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
        });

        // Starting server
        app.start(port);

        // Adding API routes
        new ApiController(app).applyRoutes();

        app.get("/", ctx -> ctx.redirect("/"));
    }

    private static OpenApiOptions getOpenApiOptions() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("My Application");
        return new OpenApiOptions(applicationInfo).path("/openapi").swagger(new SwaggerOptions("/openapi-ui"));
    }
}
