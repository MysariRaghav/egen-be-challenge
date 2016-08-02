import com.mongodb.BasicDBObject;
import lombok.Data;

@Data
public class User implements IsValid {

    String id, firstName, lastName, email, dateCreated, profilePic;
    Address address;
    Company company;

    public User(BasicDBObject dbObject) {
        this.id = dbObject.getString("id");
        this.firstName = dbObject.getString("firstName");
        this.lastName = dbObject.getString("lastName");
        this.email = dbObject.getString("email");
        this.dateCreated = dbObject.getString("dateCreated");
        this.profilePic = dbObject.getString("profilePic");
        this.address = new Address(dbObject.getString("street"), dbObject.getString("city"), dbObject.getString("zip"), dbObject.getString("state"), dbObject.getString("country"));
        this.company = new Company(dbObject.getString("name"), dbObject.getString("website"));
        //this.address = dbObject.getString("address");
        //this.company = dbObject.getString("company");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean valid() {
        return id!=null && !id.equals("") && !firstName.equals("") && !lastName.equals("") && !email.equals("")
                && !dateCreated.equals("") && profilePic.equals("");

    }
}
