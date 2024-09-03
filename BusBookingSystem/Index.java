
import java.util.*;
import com.example.busbookingpackages.*;


public class Index {

    public static void main(String args[]){

        UserPage user = new UserPage();
        RegisterPage register = new RegisterPage();
        UserOrAdmin cheak = new UserOrAdmin();
        Scanner input = new Scanner(System.in);

        while (true) {
            
        
        String who = cheak.UserorAdmin();
        System.out.println();
        if(who.equals("user")){

            System.out.println("Are you an old customer or new ? :");
            String choice = input.next();

            if(choice.equalsIgnoreCase("old")){
                    
                
                String userName = LoginPage.loginPage();
                while (true) {

                user.userPage(userName);
                }
                

            }else if(choice.equalsIgnoreCase("new")){
                
                    String userName = register.registerPage();
                    
                    while (true) {

                        user.userPage(userName);
                        }
                
            }
            
            

        }else if(who.equals("admin")){
            System.out.println("+++++");
           String adminName = LoginPage.loginPage();
           System.out.println("++++");
           while (true) {
             boolean Break = AdminPage.adminPage(adminName);
             if(Break==true){
                break;
             }

           }

        }else if(who.equals("none")){




        }

    }
}
}
