package by.viaraksa.service;

import by.viaraksa.bean.Circle;

public class CircleCalculate {
    public static double calculateSquare(Circle circle){
        return (Math.PI * circle.getRadius() * circle.getRadius());
    }

    public static double calclculatePerimetr(Circle circle){
        return (2 * Math.PI * circle.getRadius());
    }

    public static boolean croseOnlyAxis(Circle circle, double length){
        boolean result;
        if(circle.getRadius() - Math.abs(circle.getDot().getX()) <= 0){
            return (2 * Math.sqrt(square(circle.getRadius()) - square(circle.getDot().getY()))) == length;
        }
        else if(circle.getRadius() - Math.abs(circle.getDot().getY()) <= 0){
            return (2 * Math.sqrt(square(circle.getRadius()) - square(circle.getDot().getX()))) == length;
        }
        else return false;
    }

    private static double square(double a){
        return a*a;
    }

}
