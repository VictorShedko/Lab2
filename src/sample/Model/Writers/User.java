package sample.Model.Writers;
import sample.Model.Forum;
import sample.Model.Message;


public class User {
    Forum ownForum;
     User(){
        this.ownForum=new Forum();

    }



    public Message  createNewMessage(String inputTxt ){
        Message newMessage= new  Message(inputTxt);
        ownForum.addMessage(newMessage);



        return newMessage;

    }

    public Forum getForum(){
        return this.ownForum;

    }


}
