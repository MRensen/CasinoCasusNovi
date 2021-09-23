package novi.Hangman.Exceptions;

import novi.Hangman.ImageFactory;

import java.util.List;

public class RunTimeException extends Exception{
    public List<String> getImage(int index){
        return ImageFactory.getImage(index);
    };

}
