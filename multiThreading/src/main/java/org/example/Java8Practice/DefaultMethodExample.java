package org.example.Java8Practice;


interface Shape {

    default double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }


    default double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}

// Concrete class implementing the Shape interface
class ShapeCalculator implements Shape {
    // Additional functionality can be added here

        double circleArea ;
        double rectangleArea ;

    public ShapeCalculator(double radius) {
        this.circleArea=calculateCircleArea ( radius );
    }

    public ShapeCalculator(double length, double width) {
        this.rectangleArea=calculateRectangleArea ( length,width );
    }

    public ShapeCalculator() {
    }
}

// Main class to test the functionality
public class DefaultMethodExample {
    public static void main(String[] args) {
        // Create an instance of the concrete class
        ShapeCalculator shapeCalculator = new ShapeCalculator ( 32 );
        System.out.println (shapeCalculator.circleArea );
        // Display areas of a circle and a rectangle
        ShapeCalculator shapeCalculator1 = new ShapeCalculator ( 23, 32 );
        System.out.println (shapeCalculator1.rectangleArea );
    }
}
