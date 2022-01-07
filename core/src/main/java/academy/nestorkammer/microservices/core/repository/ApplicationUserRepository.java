package academy.nestorkammer.microservices.core.repository;

import academy.nestorkammer.microservices.core.model.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}