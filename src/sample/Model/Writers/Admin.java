package sample.Model.Writers;


public class Admin extends  RegisteredUser{

    public Admin(String startLogin){
    super(startLogin);
    }

    public void dellMessage(int number){
        this.ownForum.deleteMessage(number);





    }



}