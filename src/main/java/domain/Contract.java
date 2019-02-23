package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    @OneToOne
    private Tariff tariff;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> optionsForTariff;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;





    public Contract() {
    }

    public Contract(Integer number, Tariff tariff, List<Option> optionsForTariff, Client client) {
        this.number = number;
        this.tariff = tariff;
        this.optionsForTariff = optionsForTariff;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public List<Option> getOptionsForTariff() {
        return optionsForTariff;
    }

    public void setOptionsForTariff(List<Option> optionsForTariff) {
        this.optionsForTariff = optionsForTariff;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number=" + number + "\n" +
                ", tariff=" + tariff + "\n" +
                ", optionsForTariff=" + optionsForTariff + "\n" +
                ", client=" + client +
                '}';
    }
}
