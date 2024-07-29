package codigo_refatorado.models;

public interface Product {
    void setStockQuantity(int stockQuantity);
    void setPrice(double price);

    int getId();
    String getDescription();
    String getCategory();
    int getStockQuantity();
    double getPrice();

    String formatForPrinting();

    boolean isBold();

    boolean isItalic();

    String getColor();

}
