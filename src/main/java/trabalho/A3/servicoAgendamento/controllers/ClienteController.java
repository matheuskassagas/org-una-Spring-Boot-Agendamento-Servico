package trabalho.A3.servicoAgendamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import trabalho.A3.servicoAgendamento.DTO.Request.AgendamentoRequest;
import trabalho.A3.servicoAgendamento.DTO.Request.CadastroClienteRequest;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.services.ClienteService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> casdastroCliente (@Valid @RequestBody CadastroClienteRequest cadastroClienteRequest){
       Cliente cliente = clienteService.cadastroCliente(cadastroClienteRequest);
       URI uri = UriComponentsBuilder.fromPath("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> carregaCliente (@PathVariable Integer id){
        try{
            return new ResponseEntity<>(clienteService.carregaCliente(id),HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Usuario não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos (){
        return ResponseEntity.ok().body(clienteService.carregaClientes());
    }

    @PostMapping("/agendamento")
    public ResponseEntity<?> cadastroAgendamento(@RequestBody AgendamentoRequest agendamentoRequest) throws Exception {
        try{
            clienteService.cadastroAgendamento(agendamentoRequest);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

    }

}
