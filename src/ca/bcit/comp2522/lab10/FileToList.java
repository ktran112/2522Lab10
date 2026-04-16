package ca.bcit.comp2522.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading a file's contents into a list.
 *
 * @author Kiet Tran, AngEng Nay
 *
 * @version 1.0
 */
public final class FileToList
{
    private FileToList() {}

    /**
     * Reads all lines from a file at the given path and returns them as a list.
     *
     * @param directory the path to the file to read
     *
     * @return a list of lines read from the file
     *
     * @throws IOException if the file cannot be found or read
     */
    public static List<String> read(final String directory) throws IOException
    {
        final Path path;
        final List<String> myList;

        path = Paths.get(directory);
        myList = new ArrayList<>();

        try (final BufferedReader reader = Files.newBufferedReader(path))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                myList.add(line);
            }

            return myList;
        }

        catch (final IOException e)
        {
            throw new IOException("Failed to grab from: \"" + directory + "\"");
        }
    }
}