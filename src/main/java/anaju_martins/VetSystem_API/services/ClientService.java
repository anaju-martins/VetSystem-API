package anaju_martins.VetSystem_API.services;

import anaju_martins.VetSystem_API.domain.client.Client;
import anaju_martins.VetSystem_API.domain.client.ClientRequestDTO;
import anaju_martins.VetSystem_API.domain.client.ClientResponseDTO;
import anaju_martins.VetSystem_API.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDTO createClient(ClientRequestDTO data){
        Client client = new Client(data);
        if(clientRepository.findByCpf(data.cpf()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client with this CPF already exists");
        }
        Client savedClient = clientRepository.save(client);
        return toClientResponseDTO(savedClient);
    }

    public ClientResponseDTO findById(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return toClientResponseDTO(client);

    }

    public List<ClientResponseDTO> getAllClients(){
        return clientRepository.findAll().stream()
                .map(this::toClientResponseDTO)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO data){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(data.name());
        client.setEmail(data.email());
        client.setPhone(data.phone());
        Client updatedClient = clientRepository.save(client);
        return toClientResponseDTO(updatedClient);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }

    private ClientResponseDTO toClientResponseDTO(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhone()
        );
    }

}
