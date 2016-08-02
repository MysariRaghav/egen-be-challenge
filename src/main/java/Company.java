import lombok.Data;

@Data
public class Company implements IsValid{

    String name, website;

    public Company(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public boolean valid() {
        return name != null && website !=null && !name.equals("") && website.equals("");
    }
}
