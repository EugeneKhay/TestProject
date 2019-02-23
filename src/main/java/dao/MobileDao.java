package dao;

import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;

import java.util.List;

public interface MobileDao {

    Client getClient();
    List<Client> getAllClients();
    Contract getContract();
    Option getOption();
    Tariff getTariff();

    void saveClient(Client client);
}
