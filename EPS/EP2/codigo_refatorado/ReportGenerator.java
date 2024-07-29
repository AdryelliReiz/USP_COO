package codigo_refatorado;
import codigo_refatorado.decorators.BoldDecorator;
import codigo_refatorado.decorators.ColorDecorator;
import codigo_refatorado.decorators.ItalicDecorator;
import codigo_refatorado.filters.FilterStrategy;
import codigo_refatorado.models.Product;
import codigo_refatorado.sorters.SortingStrategy;
import codigo_refatorado.models.StandardProduct;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;

public class ReportGenerator {
    public static final String ALG_INSERTIONSORT = "insertion";
    public static final String ALG_QUICKSORT = "quick";

    public static final String CRIT_DESC_ASC = "descricao_c";
    public static final String CRIT_PRICE_ASC = "preco_c";
    public static final String CRIT_STOCK_ASC = "estoque_c";
    public static final String CRIT_DESC_DESC = "descricao_d";
    public static final String CRIT_PRICE_DESC = "preco_d";
    public static final String CRIT_STOCK_DESC = "estoque_d";

    public static final String FILTER_ALL = "todos";
    public static final String FILTER_STOCK_LESS_OR_EQUAL = "estoque_menor_igual";
    public static final String FILTER_CATEGORY_EQUAL = "categoria_igual";
    public static final String FILTER_PRICE_RANGE = "preco_intervalo";
    public static final String FILTER_DESCRIPTION_CONTAINS = "descricao_contem";

    private final List<Product> products;
    private final SortingStrategy sortingAlgorithm;
    private final FilterStrategy filterStrategy;
    private final String sortingCriterion;
    private final String filterCriterion;

    public ReportGenerator(List<Product> products, SortingStrategy sortingAlgorithm, String sortingCriterion,
                           FilterStrategy filterStrategy, String filterCriterion) {
        this.products = new ArrayList<>(products);
        this.sortingAlgorithm = sortingAlgorithm;
        this.sortingCriterion = sortingCriterion;
        this.filterStrategy = filterStrategy;
        this.filterCriterion = filterCriterion;
    }

    private void sortProducts() {
        sortingAlgorithm.sort(products, this.sortingCriterion);
    }

    private List<Product> filterProducts(String filterArgument) {
        return filterStrategy.filter(products, filterArgument);
    }

    private Product applyFormatting(Product product) {
        Product formattedProduct = new ColorDecorator(product, product.getColor());

        if (product.isBold()) {
            formattedProduct = new BoldDecorator(formattedProduct);
        }
        if (product.isItalic()) {
            formattedProduct = new ItalicDecorator(formattedProduct);
        }


        return formattedProduct;
    }

    public void generateReport(String outputFile) throws IOException {
        sortProducts();
        List<Product> filteredProducts = filterProducts(this.filterCriterion);

        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println("<!DOCTYPE html><html>");
            out.println("<head><title>Relatorio de produtos</title></head>");
            out.println("<body>");
            out.println("Relatorio de Produtos:");
            out.println("<ul>");

            for (Product p : filteredProducts) {
                Product formattedProduct = applyFormatting(p);
                out.println("<li>" + formattedProduct.formatForPrinting() + "</li>");
            }

            out.println("</ul>");
            out.println(filteredProducts.size() + " produtos listados, de um total de " + products.size() + ".");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public static List<Product> loadProducts(String csvFile) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true; // Flag to skip header line

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip header line
                }

                String[] fields = line.split(", ");
                int id = Integer.parseInt(fields[0].trim());
                String description = fields[1].trim();
                String category = fields[2].trim();
                int stockQuantity = Integer.parseInt(fields[3].trim());
                double price = Double.parseDouble(fields[4].trim());
                boolean bold = Boolean.parseBoolean(fields[5]);
                boolean italic = Boolean.parseBoolean(fields[6]);
                String color = fields[7].trim();

                products.add(new StandardProduct(id, description, category, stockQuantity, price, bold, italic, color));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
