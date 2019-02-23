package dao;

import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MobileDaoHibernateImpl implements MobileDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Client getClient() {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> from_clients =
                (List<Client>) sessionFactory.getCurrentSession().createQuery("from domain.Client").list();
        return from_clients;
    }

    @Override
    public Contract getContract() {
        return null;
    }

    @Override

    public Option getOption() {
        return null;
    }

    @Override
    public Tariff getTariff() {
        return null;
    }

    @Override
    public void saveClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }
}
