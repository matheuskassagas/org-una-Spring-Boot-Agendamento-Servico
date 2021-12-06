package trabalho.A3.servicoAgendamento.DTO.Request;

import trabalho.A3.servicoAgendamento.domain.Cliente;

public class AgendamentoRequest {

    private Integer horaAtendimento;

    private Integer clienteId;

    public AgendamentoRequest() {
    }

    public AgendamentoRequest(Integer horaAtendimento, Integer clienteId) {
        this.horaAtendimento = horaAtendimento;
        this.clienteId = clienteId;
    }

    public Integer getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(Integer horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
