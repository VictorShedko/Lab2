package sample.Model;

import javafx.beans.binding.StringBinding;

import java.util.Vector;
import java.util.ArrayList;


public class Forum {

    public String forumName;
    ArrayList<Message> messageList;

    public void addMessage(Message input){
    this.messageList.add(0,input);



    }

    public void deleteMessage(int numder){
        if((numder<=this.messageList.size())&&(numder>0))this.messageList.remove( numder);

    }

    public ArrayList<String>  getMessages(int numberOfMessages){
    int i=numberOfMessages;
    if(i>this.messageList.size())i=this.messageList.size();
        ArrayList<String> textList = new ArrayList<>();
        for(int index=0;index<i;index++){
            Message temp =this.messageList.get(index);
            textList.add(index,
                    temp.getname()+" : "+temp.getText());

        }
        return textList;

    }


    public Forum(){
        this.messageList=new ArrayList<Message>() ;


    }




}
