package biz.aavaz.aavazapplicantfreshjrproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import biz.aavaz.aavazapplicantfreshjrproject.model.Skill;

//!!!! For Freshers and Juniors data is accessed via plain JDBC
//!!!! For Mid Level and Senior Java Developers data access should be via hibernate
//!!!! Bonus: If you are a fresher or a junior - extra points will be given for hibernate
public class SkillDao {

    public static String dbUrl = "jdbc:sqlite:src/main/resources/database/UserDB.work.sql";

    public Skill get(long id) {
        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("select * from Skill where id=" + id);) {

            if (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt(1));
                skill.setName(resultSet.getString(2));
                skill.setLevel(resultSet.getInt(3));
                return skill;
            }

        } catch (Exception ee) {
            System.out.println("Failed to find skill");
            ee.printStackTrace();
        }
        return null;
    }

    public List<Skill> getAll() {

        List<Skill> skillsList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = conn.createStatement().executeQuery("select * from Skill");) {

            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt(1));
                skill.setName(resultSet.getString(2));
                skill.setLevel(resultSet.getInt(3));
                skillsList.add(skill);
            }

        } catch (SQLException ex) {
            System.out.println("unable to fetch data");
        }

        return skillsList;
    }

    public void save(Skill skill) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                PreparedStatement st = conn.prepareStatement("insert into Skill values(?,?,?)");) {

            st.setString(2, skill.getName());
            st.setInt(3, skill.getLevel());
            st.executeUpdate();
            
            System.out.println("!!!!! Validation before inserting duplicates to be implemented by candidate");

        } catch (SQLException ex) {
            System.out.println("unable to save skill");
        }
    }

    public void update(Skill skill) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();) {

            int st = stmt.executeUpdate("Update Skill set name='" + skill.getName() + "', level='" + skill.getLevel()
                    + "' where id=" + skill.getId());

            System.out.println("Skill updated successfully.");

        } catch (Exception ee) {
            System.out.println("Failed to update skill");
            ee.printStackTrace();
        }
    }

    public void delete(Integer id) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();) {

            stmt.executeUpdate("delete from Skill where id=" + id);

        } catch (Exception ee) {
            System.out.println("Failed to delete skill");
            ee.printStackTrace();
        }
    }
    public void save(User user) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                PreparedStatement st = conn.prepareStatement("insert into User values(?,?,?,?)");){
        	
        	
        	st.setString(2, user.getFirstname());
        	st.setString(3, user.getLastname());
            st.setInt(4, user.getAge());
            st.executeUpdate();
           
            System.out.println("User information Inserted successfully:");
           

        } catch (SQLException ex) {
            System.out.println("unable to Insert user information");
        }
    }

    public User get(int id) {
        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("select * from User where id=" + id);) {

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstname(resultSet.getString(2));
                user.setLastname(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                return user;
            }

        } catch (Exception ee) {
            System.out.println("Could not able to find user");
            ee.printStackTrace();
        }
        return null;
    }

    public void update(User user) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();) {

            int st = stmt.executeUpdate("Update User set Firstname='" + user.getFirstname() + "', lastname='" + user.getLastname() + "', age='" + user.getAge()
                    + "' where id=" + user.getId());

            System.out.println("User information updated successfully.");

        } catch (Exception ee) {
            System.out.println("Failed to update user information");
            ee.printStackTrace();
        }
    }

    public void delete(int id) {

        try (Connection conn = DriverManager.getConnection(dbUrl);
                Statement stmt = conn.createStatement();) {

            stmt.executeUpdate("delete from user where id=" + id);

        } catch (Exception ee) {
            System.out.println("An error occurs while deleting user data");
            ee.printStackTrace();
        }
    }


}
