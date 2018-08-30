package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserMessageRepo extends CrudRepository<UserMessage, Long> {

}