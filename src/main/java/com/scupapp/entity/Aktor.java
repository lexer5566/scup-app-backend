package com.scupapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "actor")
public class Aktor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aktor_id")
    private Long id;

    @NotBlank
    @Column(name = "felhasznalonev", unique = true, length = 40)
    private String felhasznalonev;

    @NotBlank
    @Column(name = "jelszo")
    private String jelszo;

    @NotBlank
    @Email
    @Column(name = "email",  unique = true)
    private String email;

    @NotBlank
    @Column(name = "vezeteknev")
    private String vezeteknev;

    @NotBlank
    @Column(name = "keresztnev")
    private String keresztnev;

    @Column(name = "mobil")
    private String mobil;

    @NotBlank
    @Column(name = "varos")
    private String varos;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;


}
