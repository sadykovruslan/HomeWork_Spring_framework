package ResultRunners;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE_KM("5"),
    TEN_KM("10");

    private final String code;

    Distance(String code) {
        this.code = code;
    }

    public static Distance of(String code){
        return Stream.of(values())
                .filter(s -> Objects.equals(s.code, code))
                .findFirst()
                .orElseThrow(() -> new  IllegalArgumentException("Invalid distance " + code));
    }
}
