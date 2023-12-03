package graphql._04_Data_fetching;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Data_fetching_Controller {
    // Data_fetching_Product 리스트를 하드코딩 방식으로 생성
    private static final List<Data_fetching_Product> products = Arrays.asList(
            new Data_fetching_Product("1", "Product A", "Description A", 100.0, 10.0, LocalDateTime.now()),
            new Data_fetching_Product("2", "Product B", "Description B", 200.0, 20.0, LocalDateTime.now()),
            new Data_fetching_Product("3", "Product C", "Description C", 300.0, 30.0, LocalDateTime.now()),
            new Data_fetching_Product("4", "Product D", "Description D", 400.0, 40.0, LocalDateTime.now()),
            new Data_fetching_Product("5", "Product E", "Description E", 500.0, 50.0, LocalDateTime.now()));

    // Product에 대한 쿼리 매핑
    @QueryMapping
    public List<Data_fetching_Product> data_fetching_products(@Argument String match) {
        if (match == null || match.isEmpty()) {
            return products;
        } else {
            return products.stream()
                    .filter(product -> product.getName().contains(match))
                    .collect(Collectors.toList());
        }
    }
}
