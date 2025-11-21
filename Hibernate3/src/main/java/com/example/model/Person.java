package com.example.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "person_id", cascade = CascadeType.ALL)
    private Passport passport;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birth_date")
    private Date birth_date;
}
