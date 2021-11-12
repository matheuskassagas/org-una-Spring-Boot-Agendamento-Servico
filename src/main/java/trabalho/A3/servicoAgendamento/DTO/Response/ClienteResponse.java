package trabalho.A3.servicoAgendamento.DTO.Response;

import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Endereco;

public class ClienteResponse {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    private Endereco endereco;

    public ClienteResponse(){}

    public ClienteResponse(Integer id, String nome, String email, String cpfOuCnpj, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
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

    public ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(cliente.getId(), cliente.getNome(),cliente.getEmail(), cliente.getCpfOuCnpj(), cliente.getEndereco());
    }
}
