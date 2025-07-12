package com.example.account_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;

    @NotNull(message = "name can't be empty")

    private String name;
    @NotNull(message = "email can't be empty")
    @Column(unique = true)
    private String email;

    @NotNull(message = "password can't be empty")
//    @JsonIgnore
    private String password;

    @PostPersist
    public void generateUserId() {
        if (this.id != null) {
            this.userId = "C" + this.id;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId=userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

}
