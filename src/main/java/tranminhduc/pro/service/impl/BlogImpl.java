package tranminhduc.pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tranminhduc.pro.model.Blog;
import tranminhduc.pro.repository.BlogRepository;
import tranminhduc.pro.service.BlogService;

public class BlogImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);

    }
}
