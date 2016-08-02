import lombok.Data;

@Data
public class Address implements IsValid{
    String street, city, zip, state, country;

    public Address(String street, String city, String zip, String state, String country) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
    }

    public boolean valid() {
        return street!=null && city!=null &&  zip!=null &&  state!=null && country!=null && street.equals("") &&
                city.equals("") &&  zip.equals("") &&  state.equals("") &&  country.equals("");
    }
}
