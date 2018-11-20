package com.sit.softwareprocess.EcommerceProject.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String facebookId;

    @Column(unique = true)
    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    @Column(name = "firstname")
    String firstName;

    @NotBlank
    @Column(name = "lastname")
    String lastName;

    @NotBlank
    String email;

    @NotBlank
    @Column(name = "telephone_number")
    String telephoneNumber;

    @NotNull
    @Column(name = "is_admin")
    boolean isAdmin = false;

    public User() {
    }

    public User(@NotBlank String username, @NotBlank String password, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, @NotBlank String telephoneNumber, @NotNull boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.isAdmin = isAdmin;
    }

    public User(@NotBlank String facebookId, @NotBlank String username, @NotBlank String password, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, @NotBlank String telephoneNumber, @NotNull boolean isAdmin) {
        this.facebookId = facebookId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.isAdmin = isAdmin;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
