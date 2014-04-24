package org.jis.generator;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Vector;

/**
 * Created by Sebastian Schindler on 24.04.2014.
 * Contains tests for the Generator class
 */
public class GeneratorTest {
    private Generator generator;

    /**
     * Setup method, makes new Generator
     */
    @Before public void setup() {
        generator = new Generator(null, 0);
    }

    /**
     * Checks createZip for creation of an empty zip file
     */
    @Test public void checkZipCreation() {
        File testFile = new File("TestFileCreateZip.zip");
        generator.createZip(testFile, new Vector<File>());  //create File
        assertTrue(testFile.exists() && !testFile.isDirectory()); //check if File exists and if it isn't a directory
                                                                  // (there might be a directory with the same name)
    }

    /**
     * Deletes testfile
     */
    @After public void tearDown() {
        File testFile = new File("TestFileCreateZip.zip");
        if (testFile.exists() && !testFile.isDirectory()) {
            if (testFile.delete()) {
                System.out.println("Testfile (TestFileCreateZip.zip) successfully deleted.");
            } else {
                System.out.println("Could not delete testfile (TestFileCreateZip.zip).");
            }
        } else {
            System.out.println("The testfile (TestFileCreateZip.zip) does not exist. "
                    + "This is serious, something went wrong.");
        }
    }


}
