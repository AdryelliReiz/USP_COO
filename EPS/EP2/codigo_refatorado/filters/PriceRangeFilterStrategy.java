package codigo_refatorado.filters;

import codigo_refatorado.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PriceRangeFilterStrategy implements FilterStrategy {

    @Override
    public List<Product> filter(List<Product> products, String filterArgument) {
        String[] args = filterArgument.split(",");
        double minPrice = Double.parseDouble(args[0]);
        double maxPrice = Double.parseDouble(args[1]);
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}

