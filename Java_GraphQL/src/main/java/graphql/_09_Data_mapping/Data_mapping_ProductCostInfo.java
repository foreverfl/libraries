package graphql._09_Data_mapping;

public class Data_mapping_ProductCostInfo {
    private String id;
    private Float cost;

    public Data_mapping_ProductCostInfo(String id, Float cost) {
        this.id = id;
        this.cost = cost;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getCost() {
        return this.cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

}
