package hello;

//import java.util.LinkedList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//Definindo que minha classe é um controller web
//Ela implementa um WebMvcConfigurer, precisa implementar alguns metodos
//pois WebMvcConfigurer é uma interface
@Controller
public class WebController implements WebMvcConfigurer{

    //private final static Logger log = LoggerFactory.getLogger(WebController.class);

    private UserMessageRepository repo;

    @Autowired
    public WebController( UserMessageRepository repo) {
        this.repo = repo;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //Adiciona um registro de ViewController.
        /*Digo que meu objeto ViewControllerRegistry adiciona uma URL a ser mapeada
            e vinculo a essa URL/endpoint uma determinada view
        */
        registry.addViewController("/results").setViewName("message");

        registry.addViewController("/endereco").setViewName("pagina");
       // registry.addViewController("/").setViewName("message");
    }


    //Aqui estou mapeando meu endpoint '/' com requisição get
    //recebendo por parametro o objeto UserMessage e 
    /* A lógica muda de acordo com o tipo de requisição */
    @GetMapping("/")
    public String showUserAndMessage(UserMessage userMessage, Model model){

        model.addAttribute("messages", repo.findAll(new Sort(Sort.Direction.DESC, "id")));
        return "message";
    }

    //Aqui estou mapeando meu endpoint '/' com requisição post
    //recebendo por parametro o objeto UserMessage
    /* A lógica muda de acordo com a requisição */
    @PostMapping("/")
    public String addValueToMessage(@Valid UserMessage userMessage, BindingResult bindingResult, Model model){
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("erro", "Verifique seu usuário.");
            model.addAttribute("messages", repo.findAll(new Sort(Sort.Direction.DESC, "id")));
            return "message";
        }

        ///messages.add(uMessage.getMessage());
        //log.info("Requisicao post: " + userMessage.toString());        
        repo.save(userMessage);
        return "redirect:/";
    }

    /* Este controlador possui requisições/metodos GET e POST, ambos mapeados para 
    o endpoint "/"
        O metodo 'showUserAndMessage' retorna o template 'uMessage', que será definido
        em src/main/resources/templates/uMessage.html
        O metodo recebe por parametro um objeto UserMessage, assim o template consegue
        associar os atributos do meu form com um objeto UserMessage.

        O metodo 'checkUserInfo' aceita dois argumentos: 
        - um objeto UserMessage, marcado como VALIDO pela anotação @Valid
        - um objeto BindingResult para possibilitar e obter erros de validação
    */
}