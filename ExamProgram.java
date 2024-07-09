import java.util.Scanner;
//scanner helps to read the user input
public class ExamProgram {

    // Variables to store the coursework and exam results
    static double ass1, ass2, ass3, cat1, cat2, finalExam;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("Choose an option:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults();
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void viewCourseworkResults() {
        Scanner input = new Scanner(System.in);
        
        // Input the results of the coursework assessments
        System.out.print("Enter the result of assignment 1: ");
        ass1 = input.nextDouble();
        System.out.print("Enter the result of assignment 2: ");
        ass2 = input.nextDouble();
        System.out.print("Enter the result of assignment 3: ");
        ass3 = input.nextDouble();
        System.out.print("Enter the result of CAT 1: ");
        cat1 = input.nextDouble();
        System.out.print("Enter the result of CAT 2: ");
        cat2 = input.nextDouble();

        // Calculate the total coursework score
        double coursework = ass1 + ass2 + ass3 + cat1 + cat2;

        // Calculate the number of coursework assessments done
        int assessmentsDone = countCourseworkAssessments();

        // Print the coursework results
        System.out.println("Total coursework score: " + coursework);
        System.out.println("Number of coursework assessments done: " + assessmentsDone);

        // Check if the student has done 2/3 of the coursework
        if (assessmentsDone < 5 * 2 / 3) {
            System.out.println("You have not completed 2/3 of the coursework. You must repeat irrespective of the final exam grade.");
        } else {
            System.out.println("You have completed 2/3 of the coursework.");
        }
    }

    public static void viewExamResults() {
        Scanner scanner = new Scanner(System.in);
        
        // Input the result of the final exam
        System.out.print("Enter the result of the final exam: ");
        finalExam = scanner.nextDouble();

        // Calculate the total coursework score (already input in viewCourseworkResults)
        double coursework = ass1 + ass2 + ass3 + cat1 + cat2;

        // Calculate the total score
        double totalScore = finalExam + coursework;

        // Print the exam results
        System.out.println("Final exam score: " + finalExam);
        System.out.println("Total score (coursework + final exam): " + totalScore);
    }

    public static int countCourseworkAssessments() {
        // Calculate the number of coursework assessments done
        double[] assessments = {ass1, ass2, ass3, cat1, cat2};
        int count = 0;
        for (int i = 0; i < assessments.length; i++) {
            if (assessments[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
