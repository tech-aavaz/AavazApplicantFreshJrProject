package biz.aavaz.aavazapplicantfreshjrproject.view;

import java.util.Scanner;
import biz.aavaz.aavazapplicantfreshjrproject.controller.SkillController;

public class MainMenu {

	public static void main(String[] args) {
		SkillController skillController = new SkillController();
		boolean isContinue = true;

		do {
			paintMenu();

			switch (processInput()) {
			case 0:// exit
				System.out.println("Good bye");
				isContinue = false;
				break;

			case 1:// add skill
				String path = "src/main/resources/skills/";
				System.out.println("Default path is for file -> "
				+ path + "\n1). Continue as default path"
						+ "\n2). Use Custom path");
				
				Scanner userScanner = new Scanner(System.in);

				if (userScanner.nextInt() == 2) {
					System.out.println("Enter your custom path:");
					path = userScanner.nextLine();
				}

				skillController.addSkill(path);
				break;
			case 2:// Show Available Skills
				skillController.printAllSkills();
				break;
			case 3:
				path = "/home/vsaini/Desktop/";
				System.out.println("Default path is for file -> " + path + "\n1). Continue as default path"
						+ "\n2). Use Custom path");
				userScanner = new Scanner(System.in);

				if (userScanner.nextInt() == 2) {
					System.out.println("Enter your custom path:");
					path = userScanner.nextLine();
				}

				skillController.updateSkill(path);
				break;
			case 4:
				skillController.printSkillById();
				break;
			case 5:
				skillController.deleteSkillById();
				break;
			default:
				break;
			}

		} while (isContinue);
	}

	public static void paintMenu() {
		System.out.println("=========================");
		System.out.println("1. Add Skill with JSON");
		System.out.println("2. Show Available Skills");
		System.out.println("3. Upadte Skill by id");
		System.out.println("4. Find Skill by id");
		System.out.println("5. Delete Skill by id");
		System.out.println("0. Exit");
	}

	public static int processInput() {
		Scanner input = new Scanner(System.in);

		return input.nextInt();
	}

}
