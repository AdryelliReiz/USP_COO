package codigo_refatorado.decorators;
import codigo_refatorado.models.Product;

public class ColorDecorator extends ProductDecorator {
    private String color;

    public ColorDecorator(Product product, String color) {
        super(product);
        this.color = color;
    }

    @Override
    public String formatForPrinting() {
        System.out.println(product.getColor());
        return "<span style=\"color:" + this.color + ";\">" + product.formatForPrinting() + "</span>";
    }

}
