package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Agendamento;

@Repository
public interface AgendamentoRepositoriesJPA extends JpaRepository<Agendamento, Integer> {
}
