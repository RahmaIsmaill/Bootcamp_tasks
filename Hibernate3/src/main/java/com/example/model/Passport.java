package com.example.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person-id")
    private Person person_id;

    @Column(name = "passport-no")
    private String passport_no;

}
