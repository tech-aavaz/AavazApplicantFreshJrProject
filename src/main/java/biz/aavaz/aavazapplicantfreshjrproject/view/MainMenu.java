package biz.aavaz.aavazapplicantfreshjrproject.view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import biz.aavaz.aavazapplicantfreshjrproject.controller.SkillController;

public class MainMenu {

	public static void main(String[] args) throws FileNotFoundException {
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
				System.out.println("Default path -> [ "
				+ path + " ]\n1). Continue as default path"
						+ "\n2). Use Custom path");
				
				Scanner userScanner = new Scanner(System.in);

				if (userScanner.nextInt() == 2) {
					System.out.println("Enter custom path with including filename & extention:");
					path = userScanner.next();
				}else {
					System.out.println("Enter filename with extention ( eq. english.json) :");
					path =path+ userScanner.next();
				}

				skillController.addSkill(path);
				break;
			case 2:// Show Available Skills
				skillController.printAllSkills();
				break;
			case 3:
				skillController.updateSkill();
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
