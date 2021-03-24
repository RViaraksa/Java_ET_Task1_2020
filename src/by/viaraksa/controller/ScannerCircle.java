package by.viaraksa.controller;

import by.viaraksa.bean.Circle;
import by.viaraksa.bean.Dot;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ScannerCircle {
    private List<Circle> circles;


    public List<Circle> scanFile() throws IOException {
        circles = new ArrayList<>();
        try(RandomAccessFile file = new RandomAccessFile
                ("C:\\Users\\PackardBell\\IdeaProjects\\Java_ET_Task1_2020\\src\\resources\\info.txt", "r")) {
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            FileChannel channel = file.getChannel();

            List<Character> characters = new ArrayList<>();
            while ( channel.read(buffer) > 0){
                buffer.flip();
                while (buffer.hasRemaining()){
                    characters.add((char) buffer.get());
                }
            }

            String fileString = characters
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            Pattern pattern = Pattern.compile(
                    "([-*|\\d]+([.|,]*)[-*|\\d]*[\\s]){2}(([-*|\\d]+([.|,]*)[-*|\\d]*))");

            Matcher matcher = pattern.matcher(fileString);
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
