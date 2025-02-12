package pl.number11shop.Client.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
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
    @Column(name = "phone_number",  length = 11)
    private String phoneNumber;
    @Column(name = "city", nullable=false, length = 30)
    private String city;
    @Column(name = "street", nullable=false, length = 30)
    private String street;
    @Column(name = "postal_code", nullable=false, length = 6)
    private String postalCode;

    public Client(String email, String firstName, String lastName,
                  String phoneNumber, String city, String street, String postalCode) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Client() {

    }

}
