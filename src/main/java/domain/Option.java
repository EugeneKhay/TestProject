package domain;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Double connectionCost;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public Option() {
    }

    public Option(String name, Double price, Double connectionCost, Tariff tariff) {
        this.name = name;
        this.price = price;
        this.connectionCost = connectionCost;
        this.tariff = tariff;
    }

    public Integer getId() {
        return id;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(Double connectionCost) {
        this.connectionCost = connectionCost;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", connectionCost=" + connectionCost +
                ", tariff=" + tariff +
                '}';
    }
}
