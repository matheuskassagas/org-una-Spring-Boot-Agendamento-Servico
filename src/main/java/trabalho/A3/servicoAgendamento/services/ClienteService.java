package trabalho.A3.servicoAgendamento.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.A3.servicoAgendamento.DTO.Request.AgendamentoRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.ClienteResponse;
import trabalho.A3.servicoAgendamento.domain.Agendamento;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Servico;
import trabalho.A3.servicoAgendamento.repositories.AgendamentoRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ClienteRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ServicoRepositoriesJPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoriesJPA clienteRepositoriesJPA;

    @Autowired
    private AgendamentoRepositoriesJPA agendamentoRepositoriesJPA;

    @Autowired
    private ServicoRepositoriesJPA servicoRepositoriesJPA;

    @PersistenceContext
    private EntityManager entityManager;

    public Cliente cadastroCliente(CadastroClienteRequest cadastroClienteRequest){
      Cliente cliente = cadastroClienteRequest.toModel(cadastroClienteRequest);
      return clienteRepositoriesJPA.save(cliente);
    }

    public ClienteResponse carregaCliente (Integer id) throws Exception {
        Optional<Cliente> cliente = clienteRepositoriesJPA.findById(id);
        if(cliente.isPresent()){
            return new ClienteResponse().toResponse(cliente.get());
        }
        throw new Exception();
    }

    public List<ClienteResponse> carregaClientes (){
        return clienteRepositoriesJPA.findAll().stream()
                .map(cliente -> new ClienteResponse().toResponse(cliente)).collect(Collectors.toList());
    }

    public void cadastroAgendamento(AgendamentoRequest agendamentoRequest) {
        Optional<Cliente> clienteProcurado = clienteRepositoriesJPA.findById(agendamentoRequest.getClienteId());
        Optional<Servico> servicoProcurado = servicoRepositoriesJPA.findById(agendamentoRequest.getServicoId());
        if(clienteProcurado.isPresent() && servicoProcurado.isPresent()){
            agendamentoRepositoriesJPA.save(new Agendamento(agendamentoRequest.getHoraAtendimento(), clienteProcurado.get(), servicoProcurado.get()));
        }
    }

    public List<Agendamento> listaAgendamentos(Integer id){
        Query query = entityManager.createQuery("select a from Agendamento a " +
                "join a.cliente c " +
                "where c.id =:id");
        query.setParameter("id", id);
        List<Agendamento> agendamentos = query.getResultList();
        return agendamentos;
    }
}
