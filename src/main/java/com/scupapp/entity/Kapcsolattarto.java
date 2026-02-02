package com.scupapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "kapcsolattarto")
public class Kapcsolattarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kapcsolattarto_id")
    private Long id;

    @NotBlank
    @Column(name = "vezeteknev")
    private String vezeteknev;

    @NotBlank
    @Column(name = "keresztnev")
    private String keresztnev;

    @Column(name = "mobil")
    private String mobil;

    @Email
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "kapcsolattarto", fetch = FetchType.LAZY)
    private Set<Workshop> workshopok;

}
