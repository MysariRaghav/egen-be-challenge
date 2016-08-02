import com.google.gson.Gson;
import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final DB db;
    private final DBCollection collection;

    public UserService(DB db) {
        this.db = db;

        this.collection = db.getCollection("users");
    }

    public List<User> getAllUsers(){

        List<User> users = new ArrayList<User>();
        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            users.add(new User((BasicDBObject) dbObject));
        }
        return users;

    }


    public void createUser(String body) {
        User user = new Gson().fromJson(body, User.class);
        collection.insert(new BasicDBObject("id", user.getId())
                .append("firstName", user.getFirstName())
                .append("lastName", user.getLastName())
                .append("email", user.getEmail())
                .append("dateCreated", user.getDateCreated())
                .append("profilePic", user.getProfilePic())
                .append("address", user.getAddress())
                .append("company", user.getCompany())
        );
    }


    public User find(String id) {
        return new User((BasicDBObject) collection.findOne(new BasicDBObject("id", new ObjectId(id))));
    }


    public User update(String id, String body) {
        User user = new Gson().fromJson(body, User.class);
        collection.update(new BasicDBObject("id", new ObjectId(id)), new BasicDBObject("$set", new BasicDBObject("firstName", user.getFirstName())
                .append("lastName", user.getLastName())
                .append("email", user.getEmail())
                .append("dateCreated", user.getDateCreated())
                .append("profilePic", user.getProfilePic())
                .append("address", user.getAddress())
                .append("company", user.getCompany())));
        return this.find(id);
    }
}
