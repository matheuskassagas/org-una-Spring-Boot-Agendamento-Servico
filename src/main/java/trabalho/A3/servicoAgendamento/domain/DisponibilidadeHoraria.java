package trabalho.A3.servicoAgendamento.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DisponibilidadeHoraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer horasSemanais;
    private Integer horaInicio;
    private Integer horaTermino;
    private Integer horasContratadas;


    public DisponibilidadeHoraria(){

    }

    public DisponibilidadeHoraria(Integer horasSemanais, Integer horaInicio, Integer horaTermino, Integer horasContratadas) {
        this.horasSemanais = horasSemanais;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.horasContratadas = horasContratadas;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(Integer horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public Integer getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Integer horaTermino) {
        this.horaTermino = horaTermino;
    }

    public Integer getHorasContratadas() {
        return horasContratadas;
    }

    public void setHorasContratadas(Integer horasContratadas) {
        this.horasContratadas = horasContratadas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilidadeHoraria that = (DisponibilidadeHoraria) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
