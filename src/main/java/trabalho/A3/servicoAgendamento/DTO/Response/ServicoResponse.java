package trabalho.A3.servicoAgendamento.DTO.Response;

import trabalho.A3.servicoAgendamento.domain.Endereco;
import trabalho.A3.servicoAgendamento.domain.Insumo;
import trabalho.A3.servicoAgendamento.domain.Servico;
import trabalho.A3.servicoAgendamento.domain.enums.TipoLocal;
import trabalho.A3.servicoAgendamento.domain.enums.TipoTrabalho;

import java.util.ArrayList;
import java.util.List;

public class ServicoResponse {

    private Integer id;
    private String nome;
    private TipoLocal tipoLocal;
    private TipoTrabalho tipoTrabalho;
    private Double valor;

    private Endereco endereco;

    private List<Insumo> insumos = new ArrayList<>();

    private ProfissionalResponse profissional;

    public ServicoResponse() {
    }

    public ServicoResponse(Integer id, String nome, TipoLocal tipoLocal, TipoTrabalho tipoTrabalho, Double valor, Endereco endereco, List<Insumo> insumos, ProfissionalResponse profissional) {
        this.id = id;
        this.nome = nome;
        this.tipoLocal = tipoLocal;
        this.tipoTrabalho = tipoTrabalho;
        this.valor = valor;
        this.endereco = endereco;
        this.insumos = insumos;
        this.profissional = profissional;
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

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public TipoTrabalho getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(TipoTrabalho tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public ProfissionalResponse getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalResponse profissional) {
        this.profissional = profissional;
    }

    public ServicoResponse toResponse(Servico servico) {
        return new ServicoResponse(
                servico.getId(),
                servico.getNome(),
                servico.getTipoLocal(),
                servico.getTipoTrabalho(),
                servico.getValor(),
                servico.getEndereco(),
                servico.getInsumos(),
                new ProfissionalResponse().toResponse(servico.getProfissional())
        );
    }
}
