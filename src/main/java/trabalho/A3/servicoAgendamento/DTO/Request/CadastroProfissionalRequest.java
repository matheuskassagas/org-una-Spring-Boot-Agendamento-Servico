package trabalho.A3.servicoAgendamento.DTO.Request;

import com.sun.istack.NotNull;
import trabalho.A3.servicoAgendamento.annotations.CpfouCnpjValido;
import trabalho.A3.servicoAgendamento.domain.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CadastroProfissionalRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @CpfouCnpjValido
    private String cpfOuCnpj;
    @NotBlank @Size(min = 8)
    private String senha;

    @NotNull
    private Endereco endereco;

    @NotNull
    private DisponibilidadeHoraria disponibilidadeHoraria;

    public CadastroProfissionalRequest(){}

    public CadastroProfissionalRequest(String nome, String email, String cpfOuCnpj, String senha, Endereco endereco, DisponibilidadeHoraria disponibilidadeHoraria) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.senha = senha;
        this.endereco = endereco;
        this.disponibilidadeHoraria = disponibilidadeHoraria;
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

    public Profissional toModel (CadastroProfissionalRequest cadastroProfissionalRequest){
        return new Profissional(cadastroProfissionalRequest.getNome(),
                cadastroProfissionalRequest.getEmail(),
                cadastroProfissionalRequest.getCpfOuCnpj(),
                cadastroProfissionalRequest.getSenha(),
                cadastroProfissionalRequest.getEndereco(),
                cadastroProfissionalRequest.getDisponibilidadeHoraria());
    }
}
