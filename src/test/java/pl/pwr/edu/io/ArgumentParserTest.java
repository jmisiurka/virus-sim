package pl.pwr.edu.io;

import org.junit.jupiter.api.Test;
import pl.pwr.edu.population.PersonParameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentParserTest {
    @Test
    void givenJsonFile_parsePersonParameters() throws IOException {
        ArgumentParser parser = new ArgumentParser();
        PersonParameters parameters = parser.parsePersonParameters("src/test/resources/testFile.json");
        assertEquals(parameters.getMinimumHealthiness(), 14);
        assertEquals(parameters.getMinimumImmunity(), 12.9);
        assertEquals(parameters.getMaximumActiveness(), 2.1);
    }
}
