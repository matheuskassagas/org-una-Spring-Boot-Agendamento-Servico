package trabalho.A3.servicoAgendamento.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private String senha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private DisponibilidadeHoraria disponibilidadeHoraria;

    public Profissional(){}

    public Profissional(String nome, String email, String cpfOuCnpj, String senha, Endereco endereco, DisponibilidadeHoraria disponibilidadeHoraria) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.senha = senha;
        this.endereco = endereco;
        this.disponibilidadeHoraria = disponibilidadeHoraria;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public DisponibilidadeHoraria getDisponibilidadeHoraria() {
        return disponibilidadeHoraria;
    }

    public void setDisponibilidadeHoraria(DisponibilidadeHoraria disponibilidadeHoraria) {
        this.disponibilidadeHoraria = disponibilidadeHoraria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
