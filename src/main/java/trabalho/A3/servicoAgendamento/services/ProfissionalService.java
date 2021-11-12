package trabalho.A3.servicoAgendamento.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroProfissionalRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.ClienteResponse;
import trabalho.A3.servicoAgendamento.DTO.Response.ProfissionalResponse;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.repositories.ClienteRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ProfissionalRepositoriesJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepositoriesJPA profissionalRepositoriesJPA;

    public Profissional cadastroProfissional(CadastroProfissionalRequest cadastroProfissionalRequest){
      Profissional profissional = cadastroProfissionalRequest.toModel(cadastroProfissionalRequest);
      return profissionalRepositoriesJPA.save(profissional);
    }

    public ProfissionalResponse carregaProfissional (Integer id) throws Exception {
        Optional<Profissional> profissional = profissionalRepositoriesJPA.findById(id);
        if(profissional.isPresent()){
            return new ProfissionalResponse().toResponse(profissional.get());
        }
        throw new Exception();
    }

    public List<ProfissionalResponse> carregaProfissionais (){
        return profissionalRepositoriesJPA.findAll().stream()
                .map(profissional -> new ProfissionalResponse().toResponse(profissional)).collect(Collectors.toList());
    }
}
