import java.io.*;
import java.util.ArrayList;

public final class HandleFile {

    private static void createFile(String absolutePath, ArrayList<String> values) {
        try {
            FileWriter file = new FileWriter(absolutePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (String value : values) {
                bufferedWriter.write(value);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch(IOException e) {

        }

    }

    private static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void updateFile(String fileName, ArrayList<String> values) {
        String directory = System.getProperty("user.home");
        String fullFileName = fileName + ".txt";
        String absolutePath = directory + File.separator + fullFileName;
        ArrayList<String> valuesFromFile = readFile(fileName);
        for (String value : values) {
            if (!valuesFromFile.contains(value))
                valuesFromFile.add(value);
        }
        createFile(absolutePath, valuesFromFile);
    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> output = new ArrayList<String>();
        String directory = System.getProperty("user.home");
        String fullFileName = fileName + ".txt";
        String absolutePath = directory + File.separator + fullFileName;
        try {
            FileReader file = new FileReader(absolutePath);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = bufferedReader.readLine();
            while(line != null) {
                output.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
        return output;
    }

    public static void replaceFile(String fileName, ArrayList<String> values) {
        String directory = System.getProperty("user.home");
        String fullFileName = fileName + ".txt";
        String absolutePath = directory + File.separator + fullFileName;
        try {
            FileWriter file = new FileWriter(absolutePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (String value : values) {
                bufferedWriter.write(value);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch(IOException e) {

        }
    }

}