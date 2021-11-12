package trabalho.A3.servicoAgendamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroProfissionalRequest;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.services.ClienteService;
import trabalho.A3.servicoAgendamento.services.ProfissionalService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> casdastroProfissional (@Valid @RequestBody CadastroProfissionalRequest cadastroProfissionalRequest){
       Profissional profissional = profissionalService.cadastroProfissional(cadastroProfissionalRequest);
       URI uri = UriComponentsBuilder.fromPath("/profissionais/{id}").buildAndExpand(profissional.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> carregaProfissional (@PathVariable Integer id){
        try{
            return new ResponseEntity<>(profissionalService.carregaProfissional(id),HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Usuario não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos (){
        return ResponseEntity.ok().body(profissionalService.carregaProfissionais());
    }



}
