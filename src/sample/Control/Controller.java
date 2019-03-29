package sample.Control;

import java.util.*;
import sample.Model.Forum;
import sample.Model.Writers.*;
import java.util.ArrayList;

public class Controller {
    private Forum forum;
    private RegisteredUser user;
    private Admin admin;
    private int mode;
    private static String ADMIN_NAME="Admin";
    public Controller(){

    this.user=new RegisteredUser();
    this.admin= new Admin(ADMIN_NAME);
    this.forum= this.user.getForum();
    this.mode=0;
    }


    public ArrayList<String> addMessage(String inputString){
    this.forum.addMessage(user.createNewMessage(inputString));

    return this.forum.getMessages(5);
    }


    public int getMode(){


        return this.mode;
}


    public ArrayList<String> dellMessage(int number){


       if(user.getLogin().equals(admin.getLogin()))this.forum.deleteMessage(number);

           return this.forum.getMessages(5);
    }





    public ArrayList<String> getMessages(int number){


        return this.forum.getMessages(5);
    }

    public void sigIn(String newLogin){


         this.user.changeLogin(newLogin);
        if(user.getLogin().equals(admin.getLogin())){
            this.mode=1;
        }else {
            this.mode=0;
        }

        return;
    }

}