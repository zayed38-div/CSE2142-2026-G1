
//File Name EmployeeManager.java

import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static String readFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.FILE_PATH)));

        String employeeLine = reader.readLine();
        reader.close();

        return employeeLine;
    }

    public static void writeFile(String data, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.FILE_PATH, append));

        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid number of arguments.");
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                String[] employees = employeeLine.split(",");

                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                System.out.println(employeeLine);

                String[] employees = employeeLine.split(",");
                Random randomGenerator = new Random();
                int randomIndex = randomGenerator.nextInt(employees.length);

                System.out.println(employees[randomIndex]);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String employeeName = args[0].substring(1);
                writeFile(", " + employeeName, true);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                String[] employees = employeeLine.split(",");
                boolean found = false;
                String searchName = args[0].substring(1);

                for (int index = 0; index < employees.length && !found; index++) {
                    if (employees[index].equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                char[] characters = employeeLine.toCharArray();
                boolean inWord = false;
                int wordCount = 0;

                for (char currentCharacter : characters) {
                    if (currentCharacter == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }

                System.out.println(wordCount + " word(s) found " + characters.length);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                String[] employees = employeeLine.split(",");
                String employeeName = args[0].substring(1);

                for (int index = 0; index < employees.length; index++) {
                    if (employees[index].equals(employeeName)) {
                        employees[index] = "Updated";
                    }
                }

                writeFile(String.join(",", employees), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");

        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String employeeLine = readFile();
                String[] employees = employeeLine.split(",");
                String employeeName = args[0].substring(1);

                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeName);

                writeFile(String.join(",", employeeList), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
