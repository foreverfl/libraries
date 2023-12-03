package graphql._09_Data_mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Data_mapping_Fetcher {
    public List<Data_mapping_Product> getProducts(String match) {
        List<Data_mapping_ProductInfo> productInfos = getMatchingProducts(match);
        List<Data_mapping_ProductCostInfo> productCosts = getProductCosts(productInfos);
        List<Data_mapping_ProductTaxInfo> productTaxes = getProductTax(productInfos);

        return mapDataTogether(productInfos, productCosts, productTaxes);
    }

    private List<Data_mapping_ProductInfo> getMatchingProducts(String match) {
        // 하드코딩된 상품 정보
        List<Data_mapping_ProductInfo> products = new ArrayList<>();
        products.add(new Data_mapping_ProductInfo("1", "Product A", "Description A"));
        products.add(new Data_mapping_ProductInfo("2", "Product B", "Description B"));
        products.add(new Data_mapping_ProductInfo("3", "Product C", "Description C"));
        products.add(new Data_mapping_ProductInfo("4", "Product D", "Description D"));
        products.add(new Data_mapping_ProductInfo("5", "Product E", "Description E"));
        return products.stream().filter(p -> p.getName().startsWith(match)).collect(Collectors.toList());
    }

    private List<Data_mapping_ProductCostInfo> getProductCosts(List<Data_mapping_ProductInfo> productInfos) {
        // 하드코딩된 상품 비용 정보
        List<Data_mapping_ProductCostInfo> productCosts = new ArrayList<>();
        productCosts.add(new Data_mapping_ProductCostInfo("1", 10.1f));
        productCosts.add(new Data_mapping_ProductCostInfo("2", 10.2f));
        productCosts.add(new Data_mapping_ProductCostInfo("3", 10.3f));
        productCosts.add(new Data_mapping_ProductCostInfo("4", 10.4f));
        productCosts.add(new Data_mapping_ProductCostInfo("5", 10.5f));
        return productCosts;
    }

    private List<Data_mapping_ProductTaxInfo> getProductTax(List<Data_mapping_ProductInfo> productInfos) {
        // 하드코딩된 상품 세금 정보
        List<Data_mapping_ProductTaxInfo> productTaxes = new ArrayList<>();
        productTaxes.add(new Data_mapping_ProductTaxInfo("1", 1.5f));
        productTaxes.add(new Data_mapping_ProductTaxInfo("2", 2.5f));
        productTaxes.add(new Data_mapping_ProductTaxInfo("3", 3.5f));
        productTaxes.add(new Data_mapping_ProductTaxInfo("4", 4.5f));
        productTaxes.add(new Data_mapping_ProductTaxInfo("5", 5.5f));
        return productTaxes;
    }

    private List<Data_mapping_Product> mapDataTogether(
            List<Data_mapping_ProductInfo> productInfos,
            List<Data_mapping_ProductCostInfo> productCosts,
            List<Data_mapping_ProductTaxInfo> productTaxes) {
        List<Data_mapping_Product> products = new ArrayList<>();
        for (Data_mapping_ProductInfo info : productInfos) {
            Data_mapping_ProductCostInfo costInfo = productCosts.stream().filter(c -> c.getId().equals(info.getId()))
                    .findFirst()
                    .orElse(null);
            Data_mapping_ProductTaxInfo taxInfo = productTaxes.stream().filter(t -> t.getId().equals(info.getId()))
                    .findFirst()
                    .orElse(null);

            if (costInfo != null && taxInfo != null) {
                products.add(new Data_mapping_Product(
                        info.getId(),
                        info.getName(),
                        info.getDescription(),
                        costInfo.getCost(),
                        taxInfo.getTax()));
            }
        }
        return products;
    }
}
