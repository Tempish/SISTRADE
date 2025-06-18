package ac.cr.ucr.SISTRADE.model;

public class Product {

    Integer ownerId;
    Double marketPrice;
    String name;
    String type;
    String description;


    public Product() {
        this.description = "";
        this.type = "";
        this.name = "";
        this.marketPrice = 0.0;
        this.ownerId = 0;
    }

    public Product(String description, String type, String name, Double marketPrice, Integer ownerID) {
        this.description = description;
        this.type = type;
        this.name = name;
        this.marketPrice = marketPrice;
        this.ownerId = ownerID;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerID) {
        this.ownerId = ownerID;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
