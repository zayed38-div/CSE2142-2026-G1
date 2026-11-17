
import java.io.*;
import java.util.*;

// Manages employee data and performs different employee operations.
public class EmployeeManager {

    // Reads employee data from the data file.
    public static String readEmployeeData() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.FILE_PATH)));

        String employeeData = reader.readLine();
        reader.close();

        return employeeData;
    }

    // Writes employee data to the file.
    public static void writeEmployeeData(String employeeData, boolean append)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.FILE_PATH, append));

        writer.write(employeeData);
        writer.close();
    }

    public static void main(String[] args) {

        // Check whether exactly one command-line argument is provided.
        if (args.length != 1) {
            System.out.println("Invalid number of arguments.");
            return;
        }

        String command = args[0];

        // Display all employee names.
        if (command.equals("l")) {
            System.out.println("Loading data ...");
            try {
                for (String employeeName : readEmployeeData().split(",")) {
                    System.out.println(employeeName);
                }
            } catch (Exception exception) {
                System.out.println("Error loading employee data.");
            }
            System.out.println("Data Loaded.");

        // Display all employees and select one randomly.
        } else if (command.equals("s")) {
            System.out.println("Loading data ...");
            try {
                String[] employeeNames = readEmployeeData().split(",");

                System.out.println(String.join(",", employeeNames));
                System.out.println(
                        employeeNames[new Random().nextInt(employeeNames.length)]);
            } catch (Exception exception) {
                System.out.println("Error selecting employee.");
            }
            System.out.println("Data Loaded.");

        // Add a new employee to the file.
        } else if (command.contains("+")) {
            System.out.println("Loading data ...");
            try {
                writeEmployeeData(", " + command.substring(1), true);
            } catch (Exception exception) {
                System.out.println("Error adding employee.");
            }
            System.out.println("Data Loaded.");

        // Search for an employee by name.
        } else if (command.startsWith("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employeeNames = readEmployeeData().split(",");
                boolean employeeFound = false;

                for (String employeeName : employeeNames) {
                    if (employeeName.equals(command.substring(1))) {
                        System.out.println("Employee found!");
                        employeeFound = true;
                        break;
                    }
                }

                if (!employeeFound) {
                    System.out.println("Employee not found!");
                }

            } catch (Exception exception) {
                System.out.println("Error searching employee.");
            }
            System.out.println("Data Loaded.");

        // Count the words in employee data.
        } else if (command.contains("c")) {
            System.out.println("Loading data ...");
            try {
                String employeeData = readEmployeeData();

                int wordCount = employeeData.split("\\s+").length;

                System.out.println(
                        wordCount + " word(s) found " + employeeData.length());
            } catch (Exception exception) {
                System.out.println("Error counting words.");
            }
            System.out.println("Data Loaded.");

        // Update an existing employee name.
        } else if (command.contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employeeNames = readEmployeeData().split(",");

                for (int index = 0; index < employeeNames.length; index++) {
                    if (employeeNames[index].equals(command.substring(1))) {
                        employeeNames[index] = "Updated";
                    }
                }

                writeEmployeeData(String.join(",", employeeNames), false);
            } catch (Exception exception) {
                System.out.println("Error updating employee.");
            }
            System.out.println("Data Updated.");

        // Delete an employee from the file.
        } else if (command.contains("d")) {
            System.out.println("Loading data ...");
            try {
                List<String> employeeList = new ArrayList<>(
                        Arrays.asList(readEmployeeData().split(",")));

                employeeList.remove(command.substring(1));

                writeEmployeeData(String.join(",", employeeList), false);
            } catch (Exception exception) {
                System.out.println("Error deleting employee.");
            }
            System.out.println("Data Deleted.");

        // Handle unsupported commands.
        } else {
            System.out.println("Invalid command.");
        }
    }
}
