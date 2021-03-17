package by.viaraksa.controller;

import by.viaraksa.bean.Circle;
import by.viaraksa.bean.Dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class ScannerCircle {
    private List<Circle> circles;

    public List<Circle> scanFile() throws FileNotFoundException {
        circles = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/resources/info.txt"));
        scanner.useDelimiter("((;\\s)|(\n))");
        while (scanner.hasNext()){
            List<Double> doubles = getNumber(scanner.next());
            circles.add(new Circle(new Dot(doubles.get(1),doubles.get(2)), doubles.get(0)));
        }
        return circles;
    }

    private List<Double> getNumber(String string){
        Pattern pattern = Pattern.compile("\\s");
        String[] strings = pattern.split(string);
        List<Double> doubles = new ArrayList<>();
        for (String s:strings) {
            doubles.add(Double.parseDouble(s));
        }
        return doubles;
    }
}
