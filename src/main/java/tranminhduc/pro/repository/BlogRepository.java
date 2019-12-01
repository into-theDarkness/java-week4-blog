package tranminhduc.pro.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tranminhduc.pro.model.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
