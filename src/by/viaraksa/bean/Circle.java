package by.viaraksa.bean;

public class Circle {
    private Dot dot;
    private double radius;

    public Circle(Dot dot, double radius) {
        this.dot = dot;
        this.radius = radius;
    }

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("dot=").append(dot);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.radius, radius) != 0) return false;
        return dot != null ? dot.equals(circle.dot) : circle.dot == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dot != null ? dot.hashCode() : 0;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
