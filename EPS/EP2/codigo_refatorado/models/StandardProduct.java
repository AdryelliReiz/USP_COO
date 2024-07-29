package codigo_refatorado.models;

import java.text.NumberFormat;

public class StandardProduct implements Product {
    private static final String SEPARATOR = ", ";

    private final int id;
    private final String description;
    private final String category;
    private int stockQuantity;
    private double price;

    private final boolean bold;

    private final boolean italic;

    private final String color;

    public StandardProduct(int id, String description, String category, int stockQuantity, double price, boolean bold, boolean italic,String color) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.bold = bold;
        this.italic = italic;
        this.color = color;
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isBold() {
        return bold;
    }
    @Override
    public boolean isItalic() {
        return italic;
    }

    @Override
    public String formatForPrinting() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return getDescription() + SEPARATOR + getCategory() + SEPARATOR + fmt.format(getPrice()) + SEPARATOR + getStockQuantity() + " unidade(s) no estoque.";
    }
}
