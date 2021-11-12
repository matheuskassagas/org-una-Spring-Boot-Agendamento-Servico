package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Cliente;
import trabalho.A3.servicoAgendamento.domain.Endereco;

@Repository
public interface EnderecoRepositoriesJPA extends JpaRepository<Endereco, Integer> {
}
