package trabalho.A3.servicoAgendamento.DTO.Request;

import com.sun.istack.NotNull;
import trabalho.A3.servicoAgendamento.domain.Endereco;
import trabalho.A3.servicoAgendamento.domain.Insumo;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.domain.Servico;
import trabalho.A3.servicoAgendamento.domain.enums.TipoLocal;
import trabalho.A3.servicoAgendamento.domain.enums.TipoTrabalho;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class ServicoProfissionalRequest {

    @NotBlank
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoLocal tipoLocal;
    @Enumerated(EnumType.STRING)
    private TipoTrabalho tipoTrabalho;
    @NotNull @Min(1)
    private Double valor;

    @NotNull
    private Endereco endereco;

    @NotNull
    private List<InsumoProfissionalRequest> insumos = new ArrayList<>();

    @NotNull
    private Integer idProfissional;

    public ServicoProfissionalRequest() {
    }

    public ServicoProfissionalRequest(String nome, TipoLocal tipoLocal, TipoTrabalho tipoTrabalho, Double valor, Endereco endereco, List<InsumoProfissionalRequest> insumos, Integer idProfissional) {
        this.nome = nome;
        this.tipoLocal = tipoLocal;
        this.tipoTrabalho = tipoTrabalho;
        this.valor = valor;
        this.endereco = endereco;
        this.insumos = insumos;
        this.idProfissional = idProfissional;
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

    public List<InsumoProfissionalRequest> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoProfissionalRequest> insumos) {
        this.insumos = insumos;
    }

    public Integer getIdProfissional() {
        return idProfissional;
    }

    public void setProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Servico toModel(ServicoProfissionalRequest servicoProfissionalRequest, Profissional profissional) {
        return new Servico(
                servicoProfissionalRequest.getNome(),
                servicoProfissionalRequest.getTipoLocal(),
                servicoProfissionalRequest.getTipoTrabalho(),
                servicoProfissionalRequest.getValor(),
                servicoProfissionalRequest.getEndereco(),
                profissional
        );
    }
}
