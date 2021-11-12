package trabalho.A3.servicoAgendamento.DTO.Response;

import trabalho.A3.servicoAgendamento.domain.*;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfissionalResponse {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    private Endereco endereco;

    private CargaHoraria cargaHoraria;

    public ProfissionalResponse(){}

    public ProfissionalResponse(Integer id, String nome, String email, String cpfOuCnpj, Endereco endereco, CargaHoraria cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.cargaHoraria = cargaHoraria;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ProfissionalResponse toResponse(Profissional profissional){
        return new ProfissionalResponse(profissional.getId(), profissional.getNome(),profissional.getEmail(), profissional.getCpfOuCnpj(), profissional.getEndereco(), profissional.getCargaHoraria());
    }
}
