package hello;

import org.springframework.data.repository.CrudRepository;

public interface UserMessageRepository extends CrudRepository<UserMessage, Long>{

    //UserMessage findById(long id);

}