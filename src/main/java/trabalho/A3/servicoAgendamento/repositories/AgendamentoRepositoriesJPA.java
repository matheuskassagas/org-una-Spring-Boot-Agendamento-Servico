package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepositoriesJPA extends JpaRepository<Agendamento, Integer> {
}
