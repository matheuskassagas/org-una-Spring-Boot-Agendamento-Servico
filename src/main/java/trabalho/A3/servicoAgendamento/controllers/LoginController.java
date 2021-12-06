package trabalho.A3.servicoAgendamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trabalho.A3.servicoAgendamento.DTO.Request.LoginRequest;
import trabalho.A3.servicoAgendamento.DTO.Response.LoginResponse;
import trabalho.A3.servicoAgendamento.services.LoginService;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse loginResponse = loginService.login(loginRequest);
        if (loginResponse == null){
            return new ResponseEntity<>("Dados incorretos ou inexistentes!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(loginResponse);
    }
}
