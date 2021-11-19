package trabalho.A3.servicoAgendamento.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroProfissionalRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.ServicoProfissionalRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.ClienteResponse;
import trabalho.A3.servicoAgendamento.DTO.Response.ProfissionalResponse;
import trabalho.A3.servicoAgendamento.DTO.Response.ServicoResponse;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Insumo;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.domain.Servico;
import trabalho.A3.servicoAgendamento.repositories.ClienteRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.InsumoRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ProfissionalRepositoriesJPA;
import trabalho.A3.servicoAgendamento.repositories.ServicoRepositoriesJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepositoriesJPA profissionalRepositoriesJPA;

    @Autowired
    private ServicoRepositoriesJPA servicoRepositoriesJPA;

    @Autowired
    private InsumoRepositoriesJPA insumoRepositoriesJPA;

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

    public Servico cadastroServico(ServicoProfissionalRequest servicoProfissionalRequest) {
        Profissional profissional = profissionalRepositoriesJPA.findById(servicoProfissionalRequest.getIdProfissional()).orElse(null);
        Servico servico = servicoProfissionalRequest.toModel(servicoProfissionalRequest, profissional);
        servicoRepositoriesJPA.save(servico);
        List<Insumo> insumos = servicoProfissionalRequest.getInsumos().stream().map(insumo -> new Insumo(insumo.getNome(), insumo.getDescricao(), servico))
        .collect(Collectors.toList());
        insumoRepositoriesJPA.saveAll(insumos);
        return servicoRepositoriesJPA.findById(servico.getId()).orElse(null);
    }

    public List<ServicoResponse> carregaServicos() {
        return servicoRepositoriesJPA.findAll().stream()
                .map(servico -> new ServicoResponse().toResponse(servico)).collect(Collectors.toList());
    }
}
