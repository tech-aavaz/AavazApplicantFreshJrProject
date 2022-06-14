package biz.aavaz.aavazapplicantfreshjrproject.view;

public class MainMenu {

    public static void main(String[] args) {
        
        boolean isContinue=true;
        
        do{
        paintMenu();
        //selected = readLine
        //processInput(num) - set isContinue based on input
        } while (isContinue);
    }
    
    public static void paintMenu(){
        System.out.println("1. Add Skill with JSON");
        System.out.println("2. Show Available Skills");
    }
    
    public static int processInput(int num){
        System.out.println("");
        return 1;
    }
    
}
