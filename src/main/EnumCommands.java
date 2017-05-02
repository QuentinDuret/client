package main;

/**
 * Created by Quentin on 01/05/2017.
 */
public enum EnumCommands {

    Close("CLOSE"),
    PostIdea("POSTIDEA"),
    ListIdea("LISTIDEA"),
    PostIdeaResponse("POSTIDEARESPONSE"),
    ListIdeaResponse("LISTIDEARESPONSE");

    private String command;

    EnumCommands(String command){
        this.command = command;
    }

    public String toString(){
        return command;
    }
}
