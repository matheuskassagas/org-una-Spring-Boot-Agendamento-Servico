package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepositoriesJPA extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByEmail(String email);
}
