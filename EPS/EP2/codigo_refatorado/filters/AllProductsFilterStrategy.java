package codigo_refatorado.filters;
import codigo_refatorado.models.Product;
import java.util.List;

public class AllProductsFilterStrategy implements FilterStrategy {
    @Override
    public List<Product> filter(List<Product> products, String argFilter) {
        return products;
    }
}
