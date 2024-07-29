package codigo_refatorado.sorters;

import codigo_refatorado.models.Product;
import java.util.List;
import java.util.Comparator;
import codigo_refatorado.ReportGenerator;

public class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(List<Product> products, String criteria) {
        products.sort(getComparator(criteria));
    }

    private Comparator<Product> getComparator(String criteria) {
        return switch (criteria) {
            case ReportGenerator.CRIT_DESC_ASC ->
                    Comparator.comparing(Product::getDescription, String.CASE_INSENSITIVE_ORDER);
            case ReportGenerator.CRIT_PRICE_ASC -> Comparator.comparingDouble(Product::getPrice);
            case ReportGenerator.CRIT_STOCK_ASC -> Comparator.comparingInt(Product::getStockQuantity);
            case ReportGenerator.CRIT_DESC_DESC ->
                    Comparator.comparing(Product::getDescription, String.CASE_INSENSITIVE_ORDER).reversed();
            case ReportGenerator.CRIT_PRICE_DESC -> Comparator.comparingDouble(Product::getPrice).reversed();
            case ReportGenerator.CRIT_STOCK_DESC -> Comparator.comparingInt(Product::getStockQuantity).reversed();
            default -> throw new IllegalArgumentException("Critério de ordenação inválido!");
        };
    }
}
