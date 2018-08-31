package hello;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserMessageRepository extends PagingAndSortingRepository<UserMessage, Long> {
        
}