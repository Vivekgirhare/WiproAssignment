package com.wipro.service;

import com.wipro.entity.Client;
import com.wipro.Daofiles.ClientRepository;
import com.wipro.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found for id: " + id));
    }
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
