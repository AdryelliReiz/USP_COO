package codigo_refatorado.sorters;
import codigo_refatorado.models.Product;
import java.util.List;

public interface SortingStrategy {
    void sort(List<Product> products, String criteria);
}
