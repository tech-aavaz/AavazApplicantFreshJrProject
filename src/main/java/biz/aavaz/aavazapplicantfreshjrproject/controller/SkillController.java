package biz.aavaz.aavazapplicantfreshjrproject.controller;

import biz.aavaz.aavazapplicantfreshjrproject.dao.SkillDao;
import biz.aavaz.aavazapplicantfreshjrproject.model.Skill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

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
        User skill=gson.fromJson(reader,User.class);
        skillDao.save(skill);
        skillDao.save(user);
    }

    public void printAllSkills() {

        List<Skill> listOfSkill = skillDao.getAll();

        listOfSkill.forEach(System.out::println);
    }

    public void printSkillById() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter skill id:");
        Skill skill = skillDao.get(input.nextLong());

        if (skill != null) {
            System.out.println(skill);
        } else {
            System.out.println("Skill not found");
        }
    }
    
    public void printAllUsers() {

        List<User> listOfUser = skillDao.getAll();

        listOfUser.forEach(System.out::println);
    }

    
    public void UserById() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter User id:");
        User user = skillDao.get(input.nextint());

        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found");
        }
    }


}
