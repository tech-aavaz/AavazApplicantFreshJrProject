package biz.aavaz.aavazapplicantfreshjrproject.dao;

import java.util.List;

//!!!! For Freshers and Juniors data is accessed via plain JDBC
//!!!! For Mid Level and Senior Java Developers data access should be via hibernate
//!!!! Bonus: If you are a fresher or a junior - extra points will be given for hibernate
public class SkillDao {

    Skill get(long id){
      //select * from Skill where id = x
    };

    List Skill getAll(){
      //select * from Skill  
    };

    void save(Skill skill){
     //insert into Skill
    };

    void update(Skill skill){
      //update Skill set where id = skill.id
    };

    void delete(integer id){
      //
    };

}
