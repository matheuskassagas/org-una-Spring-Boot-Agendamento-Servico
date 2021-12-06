package trabalho.A3.servicoAgendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.A3.servicoAgendamento.DTO.Request.LoginRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.LoginResponse;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.repositories.ClienteRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ProfissionalRepositoriesJPA;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private ClienteRepositoriesJPA clienteRepositoriesJPA;
    @Autowired
    private ProfissionalRepositoriesJPA profissionalRepositoriesJPA;

    public LoginResponse login(LoginRequest loginRequest){
        Optional<Cliente> clienteProcurado = clienteRepositoriesJPA.findByEmail(loginRequest.getEmail());
        Optional<Profissional> profissionalProcurado = profissionalRepositoriesJPA.findByEmail(loginRequest.getEmail());
        if(clienteProcurado.isPresent()){
            return new LoginResponse(clienteProcurado.get().getId(), clienteProcurado.get().getEmail(),
                    clienteProcurado.get().getNome(), false);
        } else if(profissionalProcurado.isPresent()){
            return new LoginResponse(profissionalProcurado.get().getId(), profissionalProcurado.get().getEmail(),
                    profissionalProcurado.get().getNome(), true);
        } else {
            return null;
        }
    }
}
