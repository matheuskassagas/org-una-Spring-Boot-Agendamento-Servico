package trabalho.A3.servicoAgendamento.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.ClienteResponse;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.repositories.ClienteRepositoriesJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoriesJPA clienteRepositoriesJPA;

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
}
