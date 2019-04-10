package sample.model.writers;
import sample.model.exeption.OutOfTextBoardRangeException;

public class Admin extends RegisteredUser {

    public Admin(String startLogin) {
        super(startLogin);
    }

    public void dellMessage(int number) {
        try {
            this.ownForum.deleteMessage(number);

        }catch (OutOfTextBoardRangeException ex){


        }



    }


}
