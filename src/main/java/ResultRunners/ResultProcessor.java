package ResultRunners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultProcessor {

    List<Runner> runners = new ArrayList<>();
    List<String> stringLines = new ArrayList<>();

    public void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("result.csv"));
        List<String> stringLines = new ArrayList<>();
        String line;
        while ((line = br.readLine())  != null) {
            runners.add(convertStringToRunner(line));
            for (int i = 0; i < runners.size(); i++){
                System.out.println(runners.get(i));
            }
        }
    }

    public Runner convertStringToRunner(String line) throws IOException {
        String[] increments = line.split(", ");
        Runner runner = new Runner();
        runner.setName(increments[0]);
        runner.gender = Gender.of(increments[1]);
        runner.distance = Distance.of(increments[2]);
        runner.setTime(convertResultToInt(increments[3]));
        return runner;
    }

    private int convertResultToInt(String timeString) {
        String[] time = timeString.split(":");
        return Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
    }

    public void getFastest(){
    }
}
