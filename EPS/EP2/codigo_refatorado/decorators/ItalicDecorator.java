package codigo_refatorado.decorators;
import codigo_refatorado.models.Product;

public class ItalicDecorator extends ProductDecorator {

    public ItalicDecorator(Product product) {
        super(product);
    }

    @Override
    public String formatForPrinting() {
        return "<i>" + product.formatForPrinting() + "</i>";
    }

}
