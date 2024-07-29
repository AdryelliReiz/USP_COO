package codigo_refatorado.decorators;
import codigo_refatorado.models.Product;

public class ProductDecorator implements Product {
    protected Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public int getId() {
        return product.getId();
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }

    @Override
    public String getCategory() {
        return product.getCategory();
    }

    @Override
    public int getStockQuantity() {
        return product.getStockQuantity();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        product.setStockQuantity(stockQuantity);
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public String formatForPrinting() {
        return product.formatForPrinting();
    }

    @Override
    public boolean isBold() {
        return false;
    }

    @Override
    public boolean isItalic() {
        return false;
    }

    @Override
    public String getColor() {
        return null;
    }
}
