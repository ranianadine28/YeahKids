/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author rania
 */
public class User {

    private int id;

    private String email;

    private String password;

    private Boolean isActive;

    private String roles;

    private String firstName;

    private String lastName;

    private String token;

    private String dateOfBirth;

    private String createdAt;

    private String updatedAt;

    private String activatedAt;

    private int phone;

    private String imageName;

    private String adresse;

    public User() {
    }

    public User(int id, String email, String password, Boolean isActive, String roles, String firstName, String lastName, String token, String dateOfBirth, String createdAt, String updatedAt, String activatedAt, int phone, String imageName, String adresse) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.activatedAt = activatedAt;
        this.phone = phone;
        this.imageName = imageName;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getToken() {
        return token;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getActivatedAt() {
        return activatedAt;
    }

    public int getPhone() {
        return phone;
    }

    public String getImageName() {
        return imageName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setActivatedAt(String activatedAt) {
        this.activatedAt = activatedAt;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", isActive=" + isActive + ", roles=" + roles + ", firstName=" + firstName + ", lastName=" + lastName + ", token=" + token + ", dateOfBirth=" + dateOfBirth + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", activatedAt=" + activatedAt + ", phone=" + phone + ", imageName=" + imageName + ", adresse=" + adresse + '}';
    }
    

}
