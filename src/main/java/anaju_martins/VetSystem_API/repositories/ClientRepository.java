package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);

    @Query("SELECT c FROM clients c JOIN FETCH c.pets WHERE c.id = :id")
    Optional<Client> findByIdWithPets(@Param("id") Long id);
}
