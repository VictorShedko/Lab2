package sample.Model;

import javafx.beans.binding.StringBinding;
import sample.Model.Writers.Admin;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    public String forumName;
    private static String ADMIN_NAME = "Admin";
    private List<Message> messageList;

    public List<Message> getMessageList() {
        if(messageList == null)return this.messageList=new ArrayList<>();
        return messageList;
    }

    public void addMessage(Message input) {
        this.messageList.add(0, input);


    }

    public void deleteMessage(int numder) {
        if ((numder <= getMessageList().size()) && (numder > 0)){
            messageList.remove(numder);
        }
        else{

            //throw
        }

    }

    public List<String> getMessages(int numberOfMessages) {
        numberOfMessages= numberOfMessages > this.messageList.size()? this.messageList.size():numberOfMessages;
        if(this.messageList==null)return null;
        List<String> textList = new ArrayList<>();
        for (int index = 0; index < numberOfMessages; index++) {
            Message temp = this.messageList.get(index);
            textList.add(index,
                    temp.getName() + " : " + temp.getText());

        }
        return textList;

    }


}
