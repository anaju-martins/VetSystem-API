package anaju_martins.VetSystem_API.repositories;

import anaju_martins.VetSystem_API.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
