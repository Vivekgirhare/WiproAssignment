package com.wipro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name required")
    private String name;

    @NotBlank(message="Email required")
    @Email(message="Invalid email")
    private String email;

    @NotBlank(message="Phone required")
    private String phone;

    @NotBlank(message="Address required")
    private String address;

    // Getters, setters, constructors
    public Client() {}
    public Client(Long id, String name, String email, String phone, String address) {
        this.id = id; this.name = name; this.email = email; this.phone = phone; this.address = address;
    }
    // getters and setters ...
}
