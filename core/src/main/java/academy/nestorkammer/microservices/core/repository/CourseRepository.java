package academy.nestorkammer.microservices.core.repository;

import academy.nestorkammer.microservices.core.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
