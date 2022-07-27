package biz.aavaz.aavazapplicantfreshjrproject.view;

import biz.aavaz.aavazapplicantfreshjrproject.controller.SkillController;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu {

    public static void main(String[] args) throws FileNotFoundException {

        boolean isContinue = true;

        do {
            paintMenu();

            switch (processInput()) {

                case 1:// add skill
                    addSkill();
                    break;
                case 2:
                    printSkills();
                    break;
                case 3:
                    System.out.println("This Skills already exists");
                    break;
                case 4:
                    System.out.println("At one time only one json file read");
                    break;
                case 5:// exit
                    System.out.println("Good bye");
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }

        } while (isContinue);
    }

    public static void paintMenu() {
        System.out.println("=========================");
        System.out.println("1. Add a Skill by reading a JSON file");
        System.out.println("2. Print all skills in database");
        System.out.println("3. Add a User by reading a json file");
        System.out.println("4. Get all Users by skill name");
        System.out.println("5. Exit");
    }

    public static int processInput() {

        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static void addSkill() {

        String defaultSkillsFolder = "src/main/resources/skills/";
        String filePath = "";
        SkillController skillController = new SkillController();

        System.out.println("Default skills folder -> [" + defaultSkillsFolder + " ]");
        System.out.println("1. Use default folder");
        System.out.println("2. Specify full path");

        Scanner userScanner = new Scanner(System.in);

        if (userScanner.nextInt() == 2) {
            System.out.println("Enter full path including filename & extention:");
            filePath = userScanner.next();
        } else {
            System.out.println("Enter filename with extention ( eq. english.json) :");
            filePath = defaultSkillsFolder + userScanner.next();
        }

        try {
            skillController.addSkill(filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("There was an error while processing");
        }
    }

    private static void printSkills() {
        System.out.println("User Have these skills");
    }
}
