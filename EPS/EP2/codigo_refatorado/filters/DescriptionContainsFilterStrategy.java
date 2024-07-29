package codigo_refatorado.filters;

import codigo_refatorado.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class DescriptionContainsFilterStrategy implements FilterStrategy {

    @Override
    public List<Product> filter(List<Product> products, String filterArgument) {
        return products.stream()
                .filter(product -> product.getDescription().toLowerCase().contains(filterArgument.toLowerCase()))
                .collect(Collectors.toList());
    }
}
