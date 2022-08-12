package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)//Cascate AlL é para alterar tanto na tabela quanto no relacionamento em caso de (Alterar, Excluir ...)
  @JoinColumn(name = "aluno_id")//nome da FK
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
