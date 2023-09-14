package ResultRunners;

import java.util.Objects;
import java.util.stream.Stream;

public enum Gender {
    MALE ("Male"),
    FEMALE ("Female");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public static Gender of(String code){
        return Stream.of(values())
                .filter(s ->  Objects.equals(s.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Incorrect gender " + code));
    }
}
