package com.rk.pbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="age")
    private Integer age;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private Long mobile;

    @Column(name="state")
    private String state;

    @Column(name="gender")
    private Character gender;

}
