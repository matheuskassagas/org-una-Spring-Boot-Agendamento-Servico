package trabalho.A3.servicoAgendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.A3.servicoAgendamento.domain.Insumo;
import trabalho.A3.servicoAgendamento.domain.Profissional;

import java.util.Optional;

@Repository
public interface ProfissionalRepositoriesJPA extends JpaRepository<Profissional, Integer> {

    Optional<Profissional> findByEmail(String email);
}
