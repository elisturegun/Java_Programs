import java.util.Scanner;

/**
 * Test class for monte carlo simulation
 * @author Oyku Elis Turegun 21902976
 * @version 12.10.2021
 */

public class MonteCarloSimulator {

    public static void main( String [] args) {

        //properties
        Scanner scan = new Scanner(System.in);
        Rectangle rec;
        Circle circle;
        Point ranPoint;
        int input;
        int hits = 0;

        System.out.print("Enter the number of tries: ");
        input = scan.nextInt();

        rec = new Rectangle(0,0, 100,100);
        circle = new Circle(50,50,50);
        int tries;

        for(  tries = 0; tries <input; tries++) {

            ranPoint = rec.getRandomPoint();
            if (circle.contains(ranPoint)) {
                hits++;
            }

        }
        System.out.println("Estimate for pi: " + 4.0 * hits/tries);
        scan.close();
    }
}

/**
 * Circle class
 * @author Oyku ELis Turegun 21902976
 * @version 07.10.2021
 */
public class Circle {

    //properties
    Point center;
    private double radius;

    //constructors
    public Circle(double x, double y, double radius ){
        center = new Point(x,y);
        this.radius = radius;
    }

    //methods

    /**
     * setter method for radius
     * @param newRadius
     */
    public void setRadius( double newRadius){
        radius = newRadius;
    }

    /**
     * getter method for radius
     * @return radius
     */
    public double getRadius(){
        return radius;
    }

    /**
     * getter method for center point
     * @return center
     */
    public Point getCenter(){
        return center;
    }

    /**
     * setter method for center point
     * @param p
     */
    public void setCenter( Point p ){
        center = p;
    }

    /**
     * checks if the given point is on the circle area or not
     * @param point
     * @return true if yes
     */
    public boolean contains(Point point){
        if( (point.getX() - center.getX()) * (point.getX() - center.getX()) +
                (point.getY()- center.getY()) * (point.getY() - center.getY()) <= getRadius() * getRadius()){
            return true;
        }
        else
            return false;
    }

    /**
     * string representation for the circle
     * @return circle information
     */
    public String toString() {
        return getClass() + " : radius = " + getRadius() + " center = " + center.toString();
    }


}

/**
 * Simple java class for 2D objects
 * @author Oyku ELis Turegun 21902976
 * @version 07.10.2021
 */
public class Point {

    //properties
    private double x;
    private double y;


    //constructors
    public Point( double x, double y){
        this.x = x;
        this.y = y;
    }

    //methods

    /**
     * getter method for x coordinate
     * @return
     */
    public double getX(){
        return x;
    }

    /**
     * setter method for x coordinate
     * @param  x
     */
    public void setX( double x){
        this.x = x;
    }

    /**
     * setter method for y coordinate
     * @param y
     */
    public void setY( double y){
        this.y = y;
    }

    /**
     * getter method for y coordinate
     * @return y
     */
    public double getY(){
        return y;
    }

    /**
     * string representation of the point
     * @return x and y coordinates
     */

    public String toString(){
        return "x : " + getX() + " y : " + getY();
    }

}

import java.util.*;
/**
 * Rectangle class
 * @author Oyku ELis Turegun 21902976
 * @version 07.10.2021
 */
public class Rectangle {

    //properties
    Point corner;
    private double width;
    private double height;

    //constructors
    public Rectangle( double x, double y, double width,  double height){
        this.width = width;
        this.height = height;
        corner = new Point(x,y);
    }

    //methods

    /**
     * setter  method for width
     * @param width
     */
    public void setWidth(double width){
        this.width = width;
    }

    /**
     * getter method for width
     * @return width
     */
    public double getWidth(){
        return width;
    }

    /**
     * getter method for the corner point
     * @return Point corner
     */
    public Point getCorner(){
        return corner;
    }

    /**
     * setter method for the corner point
     * @param p
     */
    public void setCorner( Point p ){
        corner = p;
    }

    /**
     * getter methold for height
     * @return height
     */
    public double getHeight(){
        return height;
    }

    /**
     * setter method for height
     * @param height
     */
    public void setHeight(double height){
        this.height = height;
    }

    /**
     * checks if the given point is in the rectangle area or not
     * @param point
     * @return true if yes
     */
    public boolean contains( Point point){
        if( point.getX() >= corner.getX() && point.getX() <= (corner.getX() + getWidth()) && point.getY() >= corner.getY() && point.getY() <= (corner.getY() + getHeight())){
            return true;
        }
        else
            return false;
    }

    /**
     * method for generating random point on the rectangle area
     * @return new point
     */
    public Point getRandomPoint(){
        Random r = new Random();

        double newX = corner.getX() + getWidth() * r.nextDouble();
        double newY = corner.getY() + getHeight() * r.nextDouble();
        return new Point(newX, newY);
    }

    /**
     * String representation of the circle
     * @return circle information
     */
    public String toString(){
        return getClass() + ": width = " + getWidth() + " height = " + getHeight() + " corner = " + corner.toString();
    }
}
