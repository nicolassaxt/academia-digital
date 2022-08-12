package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //utiliza o loombok pra fazer o gets ands sets, equals e hascodes
@NoArgsConstructor // loombok cria um construtor vazio
@AllArgsConstructor // loombok cria um construtor com todos os atributos
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//evitar o loop no json para a requsição lazy
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)//Cascate é para alterar tanto na tabela quanto no relacionamento
  @JsonIgnore //evitar o loop no json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
