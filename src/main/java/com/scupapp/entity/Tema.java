package com.scupapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tema_id")
    private Long id;

    @NotEmpty
    @Column(name = "nev")
    private String nev;

    @Column(name = "leiras")
    private String leiras;

    @OneToMany(
            mappedBy = "tema",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<SablonFile> sablonok;


    @OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
    private Set<Workshop> workshopok;


}
