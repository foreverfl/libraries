package graphql._09_Data_mapping;

public class Data_mapping_Product {
    private String id;
    private String name;
    private String description;
    private Float cost;
    private Float tax;

    public Data_mapping_Product(String id, String name, String description, Float cost, Float tax) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.tax = tax;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCost() {
        return this.cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getTax() {
        return this.tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

}
