package ResultRunners;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultProcessorTest {

    ResultProcessor rp;


    @Test
    void readFromFileTest() {
        Assertions.assertEquals(20,rp.resultString.size());

    }

    @Test
    void convertStringToRunnerTest() {

    }

    @Test
    void getFastestTest() {
    }
}