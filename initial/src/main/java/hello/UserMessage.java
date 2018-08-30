package hello;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/* Imports para definir que meu objeto será uma Entity 
    JPA.
*/
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
/* Essa classe define o objeto back para persistir dados
    ao web controller
    Edit_1: Anottation @Entity define que meu objeto UserMessage
    será uma entidade mapeada para o BD.

    Por não conter uma anottation @Table, fica definido que todo
    meu objeto/entidade será mapeado a uma tabela UserMessage
*/
@Entity
public class UserMessage{


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    private String message;

    @NotNull
    //private LocalDateTime date;

    //private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    protected UserMessage() {}

    public UserMessage(String name, String message){
        this.name = name;
        this.message = message;
        //this.date = LocalDateTime.now();
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
        return /*dtf.format(date) + */"\n@"+name+"\n"+message;
    }
}