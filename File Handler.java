import java.io.*;
import java.util.Scanner;
public class FileHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "sample.txt"; 
        while (true) {
            System.out.println("\nFile Handling Utility Menu:");
            System.out.println("1. Create and Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            try {
                switch (choice) {
                    case 1:
                        createAndWriteFile(scanner, fileName);
                        break;
                    case 2:
                        readFile(fileName);
                        break;
                    case 3:
                        modifyFile(scanner, fileName);
                        break;
                    case 4:
                        System.out.println("Thank You. Bye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("Error during file operation: " + e.getMessage());
            }
        }
    }
    private static void createAndWriteFile(Scanner scanner, String fileName) throws IOException {
        System.out.print("Enter content to write to file: ");
        String content = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File '" + fileName + "' created and written successfully.");
        }
    }
    private static void readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    private static void modifyFile(Scanner scanner, String fileName) throws IOException {
        System.out.print("Enter new content to append to the file: ");
        String contentToAppend = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine(); 
            writer.write(contentToAppend);
            System.out.println("File '" + fileName + "' modified successfully.");
        }
    }
}
