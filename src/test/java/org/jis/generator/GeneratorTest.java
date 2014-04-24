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
     * Checks if createZip() corrrectly throws the IllegalArgumentException if the first argument is null
     */
    @Test (expected = IllegalArgumentException.class)
    public void checkFirstArgumentNull() {
        generator.createZip(null, new Vector<File>());
    }

    /**
     * Checks if createZip() still works if the filelist is empty
     */
    @Test public void checkSecondArgumentNull() {
        File testFile = new File("TestFileCreateZip.zip");
        generator.createZip(testFile, null);  //create File
        assertTrue(testFile.exists() && !testFile.isDirectory()); //check if File exists and if it isn't a directory
                                                                // (there might be a directory with the same name)
    }

    /**
     * Deletes testfile
     *
     * I am aware that it probably isn't necessary to check if the file exists first, but since that points
     * to an error in this test class, I wanted to make the distinction between 'deletion failed' and 'no file there'.
     *
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

/*
Assignment 2 h): If you run the original createZip(null, new Vector<File>) (as described in the assignment,
it should fail with a NullPointerException at the FileOutputStream, and it does, I checked.
As a result, no file is created at all, so there is no file to delete. My tearDown() method actually checks if there is
a file to delete first and prints a different error message from the one it prints if the deletion just fails
(e.g. if the file is write-protected).
But why should this be Windows-specific? To my knowledge, there is no OS that can delete nonexistent files.
But *please* correct me if I'm wrong, because I really want to know if that is possible :D
 */

}
