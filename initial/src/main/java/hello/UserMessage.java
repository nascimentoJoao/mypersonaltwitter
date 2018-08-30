package hello;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
        return "O usuario "+name+" disse isso: "+message;
    }
}