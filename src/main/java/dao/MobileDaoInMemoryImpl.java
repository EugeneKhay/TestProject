package dao;

import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class MobileDaoInMemoryImpl implements MobileDao{

    public List<Client> clients = new ArrayList<>();
    public List<Contract> contracts = new ArrayList<>();
    public List<Option> options = new ArrayList<>();
    public List<Tariff> tariffs = new ArrayList<>();

    public MobileDaoInMemoryImpl() {

        Client client1 = new Client();
        client1.setFirstName("Paul");
        client1.setLastName("Stanley");
        client1.setAddress("NY");
        client1.setBirthDate(LocalDate.now());
        client1.setPassportData("1234 1234 4567");
        client1.setPassword("qwerty");
        client1.setEmail("qwert@qwe.com");
        client1.setContracts(contracts);

        Client client2 = new Client();
        client2.setFirstName("Peter");
        client2.setLastName("Criss");
        client2.setAddress("LA");
        client2.setBirthDate(LocalDate.now());
        client2.setPassportData("9999 7654 8908");
        client2.setPassword("asdfgh");
        client2.setEmail("asdf@qrty.com");
        client2.setContracts(contracts);

        Client client3 = new Client();
        client3.setFirstName("Ace");
        client3.setLastName("Frehley");
        client3.setAddress("LA");
        client3.setBirthDate(LocalDate.now());
        client3.setPassportData("6666 7654 8908");
        client3.setPassword("asdfgh");
        client3.setEmail("asdf@qrty.com");
        client3.setContracts(contracts);

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        Tariff tariff1 = new Tariff();
        tariff1.setName("Tariff=1");
        tariff1.setOptions(options);
        tariff1.setPrice(250.0);

        Tariff tariff2 = new Tariff();
        tariff2.setName("Tariff=2");
        tariff2.setOptions(options);
        tariff2.setPrice(350.0);

        tariffs.add(tariff1);
        tariffs.add(tariff2);

        Contract contract1 = new Contract();
        contract1.setNumber(1);
        contract1.setTariff(tariff1);
        contract1.setOptionsForTariff(options);

        Contract contract2 = new Contract();
        contract2.setNumber(2);
        contract2.setTariff(tariff2);
        contract2.setOptionsForTariff(options);

        contracts.add(contract1);
        contracts.add(contract2);

        Option option1 = new Option();
        option1.setTariff(tariff1);
        option1.setPrice(100.0);
        option1.setConnectionCost(1000.0);
        option1.setName("Option N1");

        Option option2 = new Option();
        option2.setTariff(tariff2);
        option2.setPrice(200.0);
        option2.setConnectionCost(2000.0);
        option2.setName("Option N2");

        options.add(option1);
        options.add(option2);
    }

    @Override
    public Client getClient() {
        return clients.get(0);
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }

    @Override
    public Contract getContract() {
        return contracts.get(0);
    }

    @Override
    public Option getOption() {
        return options.get(0);
    }

    @Override
    public Tariff getTariff() {
        return tariffs.get(0);
    }

    @Override
    public void saveClient(Client client) {
        clients.add(client);
    }
}
