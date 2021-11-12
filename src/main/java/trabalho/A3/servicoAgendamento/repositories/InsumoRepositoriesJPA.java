package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Endereco;
import trabalho.A3.servicoAgendamento.domain.Insumo;

@Repository
public interface InsumoRepositoriesJPA extends JpaRepository<Insumo, Integer> {
}
