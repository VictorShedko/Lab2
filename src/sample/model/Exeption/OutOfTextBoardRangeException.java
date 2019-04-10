package sample.model.Exeption;

public class OutOfTextBoardRangeException extends Exception {

    int number;


    public OutOfTextBoardRangeException(String message, int num){

        super(message);
        number=num;
    }

    public int getNumber() {
        return number;
    }
}
