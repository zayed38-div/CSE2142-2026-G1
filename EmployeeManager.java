
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
                for (String employee : readFile().split(",")) {
                    System.out.println(employee);
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFile().split(",");

                System.out.println(String.join(",", employees));
                System.out.println(
                        employees[new Random().nextInt(employees.length)]);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                writeFile(", " + args[0].substring(1), true);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");

        } else if (args[0].startsWith("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFile().split(",");
                boolean found = false;

                for (String employee : employees) {
                    if (employee.equals(args[0].substring(1))) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Employee not found!");
                }

            } catch (Exception exception) {
                System.out.println("Error searching employee.");
            }
            System.out.println("Data Loaded.");

        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                char[] characters = readFile().toCharArray();
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
                String[] employees = readFile().split(",");

                for (int index = 0; index < employees.length; index++) {
                    if (employees[index].equals(args[0].substring(1))) {
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
                List<String> employeeList = new ArrayList<>(
                        Arrays.asList(readFile().split(",")));

                employeeList.remove(args[0].substring(1));

                writeFile(String.join(",", employeeList), false);
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
