package pl.number11shop.Client.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "first_name",nullable=false, length = 20)
    private String firstName;
    @Column(name = "last_name", nullable=false, length = 30)
    private String lastName;
    @Column(name = "phone_number",  length = 9)
    private String phoneNumber;
    @Column(name = "city", nullable=false, length = 30)
    private String city;
    @Column(name = "street", nullable=false, length = 30)
    private String street;
    @Column(name = "house_number", nullable = false, length=10)
    private String houseNumber;
    @Column(name = "postal_code", nullable=false, length = 6)
    private String postalCode;

    public Client(String email, String firstName, String lastName,
                  String phoneNumber, String city, String street, String houseNumber, String postalCode) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
    }

    public Client() {

    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
