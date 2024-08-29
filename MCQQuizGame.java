import java.util.Scanner;

public class MCQQuizGame {
    private static final String[] LEVEL1_QUESTIONS = {
        "What is the capital of India?",
        "Who is the current President of India?",
        "Who wrote 'Wings of Fire'?",
        "Who is the father of the computer?",
        "How many bits are there in 1 Byte?"
    };

    private static final String[][] LEVEL1_OPTIONS = {       
        {"A. Delhi", "B. Punjab", "C. Shimla", "D. Himachal Pradesh"},
        {"A. Narendra Modi", "B. Droupadi Murmu", "C. Amit Shah", "D. Arvind Kejriwal"},
        {"A. William Shakespeare", "B. A.P.J Abdul Kalam", "C. Stephen King", "D. Charles Dickens"},
        {"A. Charles Babbage", "B. Stephen Hawking", "C. Alan Turing", "D. Charles Bachman"},
        {"A. 9", "B. 14", "C. 8", "D. 16"}       
    };

    private static final char[] LEVEL1_ANSWERS = {'A', 'B', 'B', 'A', 'C'};

    private static final String[] LEVEL2_QUESTIONS = {
        "What is the capital of Japan?",
        "What is the chemical symbol for water?",
        "Who painted the Mona Lisa?",
        "What is the capital of Australia?",
        "Which planet is known as the Red Planet?"
    };

    private static final String[][] LEVEL2_OPTIONS = {
        {"A. Tokyo", "B. Kyoto", "C. Osaka", "D. Seoul"},
        {"A. H2O", "B. CO2", "C. O2", "D. H2SO4"},
        {"A. Michelangelo", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Vincent van Gogh"},
        {"A. Sydney", "B. Melbourne", "C. Canberra", "D. Perth"},
        {"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"}
    };

    private static final char[] LEVEL2_ANSWERS = {'A', 'D', 'C', 'C', 'B'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scoreLevel1 = playLevel(LEVEL1_QUESTIONS, LEVEL1_OPTIONS, LEVEL1_ANSWERS, scanner);

        System.out.println("\nLevel 1 completed!");
        System.out.println("Your score in Level 1: " + scoreLevel1 + "/" + LEVEL1_QUESTIONS.length);

        if (scoreLevel1 >= 3) {
            System.out.println("Congratulations! You have scored more than 3 marks out of 5.");
            System.out.println("You have crossed Level 1 successfully and have reached Level 2.");
            int scoreLevel2 = playLevel(LEVEL2_QUESTIONS, LEVEL2_OPTIONS, LEVEL2_ANSWERS, scanner);
            System.out.println("\nLevel 2 completed!");
            System.out.println("Your score in Level 2: " + scoreLevel2 + "/" + LEVEL2_QUESTIONS.length);
            if (scoreLevel2 >= 4) {
                System.out.println("Hurray! You won!");
            } else {
                System.out.println("Sorry! You need to score 4 or more marks to win.");
            }
        } else {
            System.out.println("Sorry! You need to score more than 3 marks to cross Level 1.");
        }

        scanner.close();
    }

    private static int playLevel(String[] questions, String[][] options, char[] answers, Scanner scanner) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            displayOptions(options[i]);
            boolean answered = false;
            while (!answered) {
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D') {
                    char selectedOption = input.charAt(0);
                    if (selectedOption == answers[i]) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Incorrect!");
                    }
                    answered = true;
                } else {
                    System.out.println("Invalid input! Please select a valid option (A, B, C, or D).");
                }
            }
        }
        return score;
    }

    private static void displayOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }
}