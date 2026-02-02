package com.scupapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "workshop")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Long id;

    @NotEmpty
    @Column(name = "helyszin")
    private String helyszin;

    @NotEmpty
    @Column(name = "datum")
    private LocalDate datum;

    @NotNull
    @Column(name = "kezdes")
    private LocalDateTime kezdes;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "workshop_mentor",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "aktor_id")
    )
    private Set<Aktor> mentorok;

    //@NotNull //todo később visszatenni notnullra
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kapcsolattarto_id")
    private Kapcsolattarto kapcsolattarto;

    @NotNull
    private int mentorSzam;

   // @NotNull //todo később visszatenni notnullra
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tema_id", nullable = false)
    private Tema tema;
}
