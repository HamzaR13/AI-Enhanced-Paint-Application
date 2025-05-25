// === Refactored for showcase (original logic simplified) ===
public class TriangleShape extends AbstractShape {
    private double centerX, centerY, size;

    public TriangleShape(double x, double y, double s) {
        this.centerX = x;
        this.centerY = y;
        this.size = s;
    }

    @Override
    public void render() {
        // Placeholder - code removed for copyright reasons
    }

    @Override
    public double computeArea() {
        return size * size; // Simplified example logic
    }

    @Override
    public double computePerimeter() {
        return 4 * size; // Simplified example logic
    }
}
