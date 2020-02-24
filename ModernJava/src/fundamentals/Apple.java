package fundamentals;

public class Apple {

    enum Color { RED, GREEN}

    private Color color;
    private Integer weight;

    public Apple (Color color, int weight) {
        this.weight = weight;
        this.color = color;
    }

    public Color getColor() {

        return color;

    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Color: " + color.toString() + "|" + "Weight: " + weight;
    }
}
