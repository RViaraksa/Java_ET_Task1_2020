package by.viaraksa.view;

import by.viaraksa.bean.Circle;
import by.viaraksa.controller.ScannerCircle;
import by.viaraksa.service.CircleCalculate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Viewer {
    public static void main(String[] args) {
        ScannerCircle scannerCircle = new ScannerCircle();
        try {
            scannerCircle.scanFile();
            System.out.println("Объекты из файла были обработаны");
            for (Circle circle: scannerCircle.getCircles()){
                System.out.println(circle);
            }

            scannerCircle.getCircles()
                    .stream()
                    .forEach(c -> System.out.println("Периметр круга {"+c.hashCode()+"} = "+CircleCalculate.calclculatePerimetr(c)));

            scannerCircle.getCircles()
                    .stream()
                    .forEach(c -> System.out.println("Площадь круга {"+c.hashCode()+"} = "+CircleCalculate.calculateSquare(c)));

            scannerCircle.getCircles()
                    .stream()
                    .forEach(c -> System.out.println
                            ("круг {"+c.hashCode()+"} пересекает только одну ось на 5 ед? "+CircleCalculate.croseOnlyAxis(c, 2)));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
