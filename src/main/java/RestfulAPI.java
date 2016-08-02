import com.mongodb.*;

import static spark.Spark.*;


public class RestfulAPI {

    public static void main(String[] args) throws Exception {
        new UserResource(new UserService(mongo()));
    }

    private static DB mongo() throws Exception {
        String username = "root";
        String password = "password";
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
        DB db = mongoClient.getDB("admin");
        if (db.authenticate(username, password.toCharArray())) {
            return db;
        } else {

            System.out.print(db.authenticate(username, password.toCharArray())+ username +password);
            throw new RuntimeException("Not able to authenticate with MongoDB");
        }
    }
}