package trabalho.A3.servicoAgendamento.DTO.Request;

import com.sun.istack.NotNull;
import trabalho.A3.servicoAgendamento.annotations.CpfouCnpjValido;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Endereco;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CadastroClienteRequest {

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

    public CadastroClienteRequest(){}

    public CadastroClienteRequest(String nome, String email, String cpfOuCnpj, String senha, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.senha = senha;
        this.endereco = endereco;
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

    public Cliente toModel (CadastroClienteRequest cadastroClienteRequest){
        return new Cliente(cadastroClienteRequest.getNome(), cadastroClienteRequest.getEmail(), cadastroClienteRequest.getCpfOuCnpj(), cadastroClienteRequest.getSenha(), cadastroClienteRequest.getEndereco());
    }
}
