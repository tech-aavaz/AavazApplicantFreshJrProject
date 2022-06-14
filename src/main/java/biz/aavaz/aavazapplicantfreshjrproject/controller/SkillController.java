package biz.aavaz.aavazapplicantfreshjrproject.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class SkillController {
    
    public void addSkill(String path){
        //deserialize the skill file at path using gson getting a skill object
        //skill object should be saved with SkillDAO.save(skill)
    }
    
    public void printAllSkills(){
        //SkillDAO.getAll
        //sout the list
    }
    
}
