package br.cefetmg.gestaodechamadas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "membro")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Nome é campo obrigatório para inserir ou modificar um Membro")
    @Column(nullable = false, length = 50)
    private String nome;

}
