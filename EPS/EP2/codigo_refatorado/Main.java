package codigo_refatorado;

import codigo_refatorado.filters.*;
import codigo_refatorado.sorters.InsertionSortStrategy;
import codigo_refatorado.sorters.QuickSortStrategy;
import codigo_refatorado.sorters.SortingStrategy;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Uso:");
            System.out.println("\tjava " + ReportGenerator.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <arquivo de entrada (.csv)> <arquivo de saída (.html)>");
            System.out.println("Onde:");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println("\tcritério de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou 'descricao_d' ou 'estoque_d'");
            System.out.println("\tcritério de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'preco_intervalo' ou 'descricao_contem'");
            System.out.println("\tparâmetro de filtragem: 'estoque_menor_igual' => <valor estoque> | 'categoria_igual' => <categoria> | 'preco_intervalo' => <min,max> | 'descricao_contem' => <string_descrição>");
            System.out.println("\tarquivo de entrada (.csv): diretório do arquivo.csv");
            System.out.println("\tarquivo de saída (.html): diretório do arquivo de saída.html");
            System.out.println();
            System.exit(1);
        }

        String algorithmOption = args[0];
        String sortingCriterionOption = args[1];
        String filteringCriterionOption = args[2];
        String filterParameterOption = args[3];
        String fileNameIn = args[4];
        String fileNameOut = args[5];

        SortingStrategy sortingStrategy = getSortingStrategy(algorithmOption);
        FilterStrategy filterStrategy = getFilterStrategy(filteringCriterionOption);

        ReportGenerator reportGenerator = new ReportGenerator(
                ReportGenerator.loadProducts(fileNameIn),
                sortingStrategy,
                sortingCriterionOption,
                filterStrategy,
                filterParameterOption
        );

        try {
            reportGenerator.generateReport(fileNameOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static SortingStrategy getSortingStrategy(String algorithmOption) {
        return switch (algorithmOption) {
            case ReportGenerator.ALG_INSERTIONSORT -> new InsertionSortStrategy();
            case ReportGenerator.ALG_QUICKSORT -> new QuickSortStrategy();
            default -> throw new IllegalArgumentException("Algoritmo de ordenação inválido: " + algorithmOption);
        };
    }

    private static FilterStrategy getFilterStrategy(String filteringCriterionOption) {
        return switch (filteringCriterionOption) {
            case ReportGenerator.FILTER_ALL -> new AllProductsFilterStrategy();
            case ReportGenerator.FILTER_STOCK_LESS_OR_EQUAL -> new StockLessThanOrEqualFilterStrategy();
            case ReportGenerator.FILTER_CATEGORY_EQUAL -> new SameCategoryFilterStrategy();
            case ReportGenerator.FILTER_PRICE_RANGE -> new PriceRangeFilterStrategy();
            case ReportGenerator.FILTER_DESCRIPTION_CONTAINS -> new DescriptionContainsFilterStrategy();
            default -> throw new IllegalArgumentException("Critério de filtragem inválido: " + filteringCriterionOption);
        };
    }
}
