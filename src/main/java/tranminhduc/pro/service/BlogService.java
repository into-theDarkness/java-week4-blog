package tranminhduc.pro.service;

import tranminhduc.pro.model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
