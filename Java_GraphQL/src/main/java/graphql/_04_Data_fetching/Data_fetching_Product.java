package graphql._04_Data_fetching;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import graphql.schema.DataFetchingEnvironment;

public class Data_fetching_Product {
    private String id;
    private String name;
    private String description;
    private Double cost;
    private Double tax;
    private LocalDateTime launchDate;

    public Data_fetching_Product(String id, String name, String description, double cost, double tax,
            LocalDateTime launchDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.tax = tax;
        this.launchDate = launchDate;
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

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTax() {
        return this.tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getLaunchDate(DataFetchingEnvironment environment) {
        String dateFormat = environment.getArgument("dateFormat");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return launchDate.format(formatter);
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }
}
