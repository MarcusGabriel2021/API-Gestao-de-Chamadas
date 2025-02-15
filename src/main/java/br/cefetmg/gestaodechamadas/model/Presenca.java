package br.cefetmg.gestaodechamadas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPresenca;

    @ManyToOne
    @JoinColumn(name = "idAula")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "idMembro")
    private Membro membro;

    private boolean status;

}
