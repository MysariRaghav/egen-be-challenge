import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
        setupEndpoints();
    }

    private void setupEndpoints() {

        get("/hello", (req, res) -> "Hello World");

        post("/user", "application/json", (request, response) -> {
            userService.createUser(request.body());
            response.status(201);
            return response;
        }, new JsonTransformer());

        get("/user/:id", "application/json", (request, response)

                -> userService.find(request.params(":id")), new JsonTransformer());

        get("/users", "application/json", (request, response)

                -> userService.getAllUsers(), new JsonTransformer());

        put("/updateUser/:id", "application/json", (request, response)

                -> userService.update(request.params(":id"), request.body()), new JsonTransformer());
    }



}
