package codigo_refatorado.filters;
import codigo_refatorado.models.Product;
import java.util.List;
import java.util.stream.Collectors;

public class StockLessThanOrEqualFilterStrategy implements FilterStrategy {
    @Override
    public List<Product> filter(List<Product> products, String argFilter) {
        int stockQuantity = Integer.parseInt(argFilter);
        return products.stream()
                .filter(p -> p.getStockQuantity() <= stockQuantity)
                .collect(Collectors.toList());
    }
}
