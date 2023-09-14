package ResultRunners;

public record Result(Runner runner, Distance distance, int time) {

    public boolean hasGender (Gender gender){
        return runner.gender == gender;
    }

    public boolean hasDistance (Distance distance){
        return runner.distance == distance;
    }
}
