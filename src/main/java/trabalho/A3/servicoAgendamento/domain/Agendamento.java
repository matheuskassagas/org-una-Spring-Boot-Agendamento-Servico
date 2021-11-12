package trabalho.A3.servicoAgendamento.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer horaAtendimento;

    public Agendamento(){}

    public Agendamento(Integer horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(Integer horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
