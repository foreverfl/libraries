package graphql._09_Data_mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Data_mapping_Controller {
    private final Data_mapping_Fetcher dataMappingFetcher;

    @Autowired
    public Data_mapping_Controller(Data_mapping_Fetcher dataMappingFetcher) {
        this.dataMappingFetcher = dataMappingFetcher;
    }

    @QueryMapping
    public List<Data_mapping_Product> dataMappingProducts(String match) {
        return dataMappingFetcher.getProducts(match);
    }
}
