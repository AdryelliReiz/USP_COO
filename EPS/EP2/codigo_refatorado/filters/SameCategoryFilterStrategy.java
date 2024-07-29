package codigo_refatorado.filters;

import codigo_refatorado.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class SameCategoryFilterStrategy implements FilterStrategy {
    @Override
    public List<Product> filter(List<Product> products, String argFilter) {
        return products.stream()
                .filter(p -> String.valueOf(p.getStockQuantity()).equalsIgnoreCase(argFilter))
                .collect(Collectors.toList());
    }
}
