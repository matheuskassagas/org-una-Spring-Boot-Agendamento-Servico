package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Profissional;
import trabalho.A3.servicoAgendamento.domain.Servico;

@Repository
public interface ServicoRepositoriesJPA extends JpaRepository<Servico, Integer> {
}
