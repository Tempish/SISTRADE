package ac.cr.ucr.SISTRADE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @Column(nullable = false)
    private Integer ownerId;
    @Column(nullable = false)
    private Double marketPrice;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, length = 30)
    private String type;
    @Column(nullable = false)
    private String description;

    public Product(Integer id, Integer ownerId, Double marketPrice, String name, String type, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.marketPrice = marketPrice;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Product() {
        this.description = "";
        this.type = "";
        this.name = "";
        this.marketPrice = 0.0;
        this.ownerId = 0;
        this.id = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

