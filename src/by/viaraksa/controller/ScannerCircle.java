package by.viaraksa.controller;

import by.viaraksa.bean.Circle;
import by.viaraksa.bean.Dot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ScannerCircle {
    private List<Circle> circles;


    public List<Circle> scanFile() throws FileNotFoundException {
        circles = new ArrayList<>();
        File file = new File("src/resources/info.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        Pattern pattern = Pattern.compile(
                "([-*|\\d]+[.|,][-*|\\d]+[\\s]){2}(([-*|\\d]+[.|,][-*|\\d]+))");

        List<String> string = reader.lines().collect(Collectors.toList());

        for (String line : string) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                List<Double> doubles = getNumber(matcher.group());
                circles.add(new Circle(new Dot(doubles.get(1), doubles.get(2)), doubles.get(0)));
            }

        /*reader.lines()
                .map(pattern::matcher)
                //не работает т.к. метод find ищет первое совпадение
                //и переходит к следующему шагу, при этом
                //другие совпланеия в этой строке терются
                //если как то сделать это в виде:
                //while(matcher.find) то все заработает
                .peek(Matcher:: find)
                .map(matcher -> matcher.group())
                .collect(Collectors.toList())
                .forEach(System.out::println);*/



        }
        return circles;
    }

    public List<Circle> getCircles() {
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
