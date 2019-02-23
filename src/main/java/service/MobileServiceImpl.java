package service;

import dao.MobileDao;
import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MobileServiceImpl implements MobileService{

    @Autowired
    private MobileDao dao;

    @Override
    @Transactional
    public Client getClientById(Integer id) {
        return dao.getClientById(id);
    }

    @Override
    @Transactional
    public List<Client> getAllClients() {
        return dao.getAllClients();
    }

    @Override
    public Contract getContract() {
        return dao.getContract();
    }

    @Override
    public Option getOption() {
        return dao.getOption();
    }

    @Override
    public Tariff getTariff() {
        return dao.getTariff();
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        dao.saveClient(client);
    }
}
