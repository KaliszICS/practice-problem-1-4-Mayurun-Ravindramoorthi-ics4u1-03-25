import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PracticeProblem {

	public static void main(String args[]) {
		fileAppend("sir","file2.txt");
		fileAppend("\n how are you doing","file2.txt");
		
	}

    public static String getName(int lineNumber, String file) {
        String line = getLine(lineNumber, file);
        if (line.isEmpty()) return "";
        
        String[] parts = line.split(" ");
        if (parts.length < 3) return ""; 

        
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < parts.length - 2; i++) {
            if (i > 0) name.append(" ");
            name.append(parts[i]);
        }
        return name.toString();
    }

    public static int getAge(int lineNumber, String file) {
        String line = getLine(lineNumber, file);
        if (line.isEmpty()) return -1;

        String[] parts = line.split(" ");
        if (parts.length < 3) return -1; 

        return Integer.parseInt(parts[parts.length - 2]); 
    }

    public static int getNumber(int lineNumber, String file) {
        String line = getLine(lineNumber, file);
        if (line.isEmpty()) return -1;

        String[] parts = line.split(" ");
        if (parts.length < 3) return -1; 

        return Integer.parseInt(parts[parts.length - 1]); 
    }

    public static String getLine(int lineNumber, String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                if (count == lineNumber) {
                    return line;
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ""; 
    }
	
    public static void fileAppend(String output, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { 
            writer.write(output);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



