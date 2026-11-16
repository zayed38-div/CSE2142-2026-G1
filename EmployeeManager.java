
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid number of arguments.");
            return;
        }

        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
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
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String employeeName = args[0].substring(1);
                writer.write(", " + employeeName);
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
                String[] employees = employeeLine.split(",");
                String employeeName = args[0].substring(1);
                for (int index = 0; index < employees.length; index++) {
                    if (employees[index].equals(employeeName)) {
                        employees[index] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", employees));
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");

        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String employeeLine = reader.readLine();
                String[] employees = employeeLine.split(",");
                String employeeName = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeName);
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", employeeList));
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
