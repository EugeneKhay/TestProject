package service;

import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;

import java.util.List;

public interface MobileService {

    Client getClientById(Integer id);
    List<Client> getAllClients();
    Contract getContract();
    Option getOption();
    Tariff getTariff();

    void saveClient(Client client);
}
