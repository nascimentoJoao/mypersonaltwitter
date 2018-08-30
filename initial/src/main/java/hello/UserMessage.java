package hello;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
/* Essa classe define o objeto back para persistir dados
    ao web controller
*/
@Entity
public class UserMessage{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    private String message;

    public UserMessage(){}

    public UserMessage(String name, String messagem){
        this.name = name;
        message = messagem;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String toString(){
        return "@"+name+" "+message;
    }
}