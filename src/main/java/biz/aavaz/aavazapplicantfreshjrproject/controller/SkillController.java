package biz.aavaz.aavazapplicantfreshjrproject.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import biz.aavaz.aavazapplicantfreshjrproject.dao.SkillDao;
import biz.aavaz.aavazapplicantfreshjrproject.model.Skill;

public class SkillController {
	SkillDao skillDao = new SkillDao();

	public void addSkill(String path) throws FileNotFoundException {
		// deserialize the skill file at path using gson getting a skill object
		// skill object should be saved with SkillDAO.save(skill)

		Gson gson = new Gson();
		File file = new File(path);
		file.setReadable(true);
		JsonReader reader = new JsonReader(new FileReader(file));
		Skill skill = gson.fromJson(reader, Skill.class);
		skillDao.save(skill);
	}

	public void updateSkill() {
		Scanner input = new Scanner(System.in);
		Skill skill = new Skill();

		System.out.println("Enter Skill id :");
		skill.setId(input.nextInt());

		System.out.println("Enter Skill name :");
		skill.setName(input.next());

		System.out.println("Enter Skill level :");
		skill.setLevel(input.nextInt());

		skillDao.update(skill);
	}

	public void printAllSkills() {
		List<Skill> listOfSkill = skillDao.getAll();
		listOfSkill.forEach(System.out::println);
	}

	public void printSkillById() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter skill id:");
		Skill skill = skillDao.get(input.nextInt());
		if (skill != null) {
			System.out.println(skill);
		} else {
			System.out.println("skill not found");
		}
	}

	public void deleteSkillById() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter skill id:");
		skillDao.delete(input.nextInt());

		printAllSkills();
	}
}
