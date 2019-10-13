package com.proyect.app.shop;

public class User {

    private int id;
    private String username;
    private String email;
    private String email_verified_at;
    private String admin;
    private String created_at;
    private String updated_at;




    public User(int id, String name, String email,  String email_verified_at, String admin, String created_at, String update_at) {
        this.id = id;
        this.username = name;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.admin = admin;
        this.created_at = created_at;
        this.updated_at = update_at;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public String getEmailVerifiedAt() {
        return email_verified_at;
    }

    public String getAdmin() {
        return admin;
    }


    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", email_verified_at='" + email_verified_at + '\'' +
                ", admin='" + admin + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
