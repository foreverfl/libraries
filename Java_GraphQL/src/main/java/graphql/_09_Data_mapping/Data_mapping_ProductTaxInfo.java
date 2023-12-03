package graphql._09_Data_mapping;

public class Data_mapping_ProductTaxInfo {
    private String id;
    private Float tax;

    public Data_mapping_ProductTaxInfo(String id, Float tax) {
        this.id = id;
        this.tax = tax;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTax() {
        return this.tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }
}
