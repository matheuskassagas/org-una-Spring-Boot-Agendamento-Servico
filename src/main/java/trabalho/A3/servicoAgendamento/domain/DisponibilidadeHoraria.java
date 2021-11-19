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
    private String horasSemanais;
    private String horaInicio;
    private String horaTermino;
    
    public DisponibilidadeHoraria(){

    }

    public DisponibilidadeHoraria(String horasSemanais, String horaInicio, String horaTermino) {
        this.horasSemanais = horasSemanais;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(String horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
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
