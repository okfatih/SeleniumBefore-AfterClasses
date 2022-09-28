package seleniumPratik;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        /*
        Verify that we have pomxml file
        in our project
         */
        String dosyaYolu = "C:\\Users\\Admin\\IdeaProjects\\demo\\com.81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
