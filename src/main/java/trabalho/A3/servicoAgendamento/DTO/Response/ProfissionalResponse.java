package trabalho.A3.servicoAgendamento.DTO.Response;

import trabalho.A3.servicoAgendamento.domain.*;

public class ProfissionalResponse {

    private Integer id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    private Endereco endereco;

    private DisponibilidadeHoraria disponibilidadeHoraria;

    private Servico servico;

    public ProfissionalResponse(){}

    public ProfissionalResponse(Integer id, String nome, String email, String cpfOuCnpj, Endereco endereco, DisponibilidadeHoraria disponibilidadeHoraria) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public DisponibilidadeHoraria getCargaHoraria() {
        return disponibilidadeHoraria;
    }

    public void setCargaHoraria(DisponibilidadeHoraria disponibilidadeHoraria) {
        this.disponibilidadeHoraria = disponibilidadeHoraria;
    }

    public ProfissionalResponse toResponse(Profissional profissional){
        return new ProfissionalResponse(profissional.getId(),
                profissional.getNome(),
                profissional.getEmail(),
                profissional.getCpfOuCnpj(),
                profissional.getEndereco(),
                profissional.getDisponibilidadeHoraria());
    }
}
