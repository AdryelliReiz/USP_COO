package codigo_refatorado.decorators;
import codigo_refatorado.models.Product;

public class BoldDecorator extends ProductDecorator {

    public BoldDecorator(Product product) {
        super(product);
    }

    @Override
    public String formatForPrinting() {
        return "<b>" + product.formatForPrinting() + "</b>";
    }

}
