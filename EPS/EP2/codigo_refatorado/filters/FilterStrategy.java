package codigo_refatorado.filters;
import codigo_refatorado.models.Product;
import java.util.List;

public interface FilterStrategy {
    List<Product> filter(List<Product> products, String argFilter);
}
