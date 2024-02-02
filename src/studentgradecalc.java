import java.util.Scanner;
class studentgradecalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Student student = new Student();
            student.inputMarks(scanner);
            student.calculateResults();
            student.displayResults();

            System.out.println("\nDo you want to check another set of marks? (yes/no):");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using the Student Grade Calculator!");
        scanner.close();
    }
}

class Student {
    private int numOfSubjects;
    private int totalMarks;
    private double averagePercentage;
    private char grade;

    public void inputMarks(Scanner scanner) {
        System.out.println("Enter the number of subjects:");
        numOfSubjects = scanner.nextInt();

        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.println("Enter marks for Subject " + i + " (out of 100):");
            int marks = scanner.nextInt();

            // Validate marks to be between 0 and 100
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                i--; // Decrement i to re-enter marks for the same subject
            } else {
                totalMarks += marks;
            }
        }
    }

    public void calculateResults() {
        averagePercentage = (double) totalMarks / numOfSubjects;
        grade = calculateGrade(averagePercentage);
    }

    public void displayResults() {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}