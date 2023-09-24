package ResultRunners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultProcessor {
    List<String> resultString = new ArrayList<>();
    public List <Result> results = new ArrayList<>();


    @Autowired
    void readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("result.csv"));
        String line;
        while ((line = br.readLine())  != null) {
            resultString.add(line);
        }
    }

    @Autowired
    public List <Result> convertStringToRunner() throws IOException {
        readFromFile();
        for (int i = 0; i<resultString.size(); i++) {
            String[] increments = resultString.get(i).split(", ");

            String name = increments[0];
            Gender gender = Gender.of(increments[1]);
            Distance distance = Distance.of(increments[2]);
            int time = convertResultToInt(increments[3]);

            Runner runner = new Runner(name, gender);
            Result result = new Result(runner,distance,time);
            results.add(result);
        }
        return results;
    }

    @Autowired
    private int convertResultToInt(String timeString) {
        String[] time = timeString.split(":");
        return Integer.valueOf(time[0])*60 + Integer.parseInt(time[1]);
    }

    public List<Result> getFastest(Gender gender, Distance distance, int quantity) throws IOException {
        convertStringToRunner();
        List<Result> changedRunners = results.stream()
                .filter(s -> s.hasGender(gender))
                .filter(s -> s.hasDistance(distance))
                .sorted(Comparator.comparing(Result::time))
                .limit(quantity)
                .collect(Collectors.toList());
        printResults(changedRunners);
        return changedRunners;
    }

    public void printResults(List<Result> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
