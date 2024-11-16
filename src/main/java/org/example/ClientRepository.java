package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ClientRepository {
    private ArrayList<Client> clients;
    private HashMap<Integer, Client> clientIdToClient;

    public ClientRepository() {
        clients = new ArrayList<Client>();
        clientIdToClient = new HashMap<Integer, Client>();
    }

    public void add(Client client) {
        clients.add(client);
        clientIdToClient.put(client.getId(), client);
    }

    public Client getClient(int index){
        return clients.get(index);
    }

    public Client getClientById(int id){
        return clientIdToClient.get(id);
    }

    public void removeClient (Client client){
        clients.remove(client);
    }
}
