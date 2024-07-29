package codigo_refatorado.sorters;

import codigo_refatorado.models.Product;
import java.util.List;
import java.util.Comparator;
import codigo_refatorado.ReportGenerator;

public class InsertionSortStrategy implements SortingStrategy {
    @Override
    public void sort(List<Product> products, String criteria) {
        Comparator<Product> comparator = getComparator(criteria);
        for (int i = 1; i < products.size(); i++) {
            Product key = products.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(products.get(j), key) > 0) {
                products.set(j + 1, products.get(j));
                j--;
            }
            products.set(j + 1, key);
        }
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
