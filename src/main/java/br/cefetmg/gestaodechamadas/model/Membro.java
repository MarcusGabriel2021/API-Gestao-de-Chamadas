package br.cefetmg.gestaodechamadas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "membro")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembro;

    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma turma;

    @Column(nullable = false, length = 50)
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String telefone;
    private String tipo;

}
