interface Shape {
    double getArea();
}
class Rectangle implements Shape {
    double width;
    double height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
}
class Circle implements Shape {
  double radius;
  Circle(double radius) {
        this.radius = radius;
    }    
     public double getArea() {
        return Math.PI * radius * radius;
    }
}
class Triangle implements Shape {
     double base;
     double height;

    public Triangle(double base, double height) {
       this.base = base;
       this.height = height;
    }
    public double getArea() {
        return 0.5 * base * height;
    }
}
public class add1 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 3);
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(6, 2.5);
System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());
    }
}

