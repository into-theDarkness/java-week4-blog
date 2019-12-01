package tranminhduc.pro.controller;

import com.mysql.cj.jdbc.BlobFromLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tranminhduc.pro.model.Blog;
import tranminhduc.pro.service.BlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/testconfig")
    public String testConfig(){
        return "test";
    }
    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/create-blog")
    public ModelAndView saveBlog(Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New Blog has been created !");
        return modelAndView;
    }
    @GetMapping("/blogs")
    public ModelAndView showBlogList(){
        Iterable<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView(("blog/list"));
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/listcontent")
    public ModelAndView showContentList(){
        Iterable<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/listcontent");
        modelAndView.addObject("blogs", blogs  );
        return modelAndView;
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null){
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }

    }
    @PostMapping("/edit-blog")
    public ModelAndView updateEdit(Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "Blog has been updated");
        return modelAndView;
    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null){
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return  modelAndView;
        }
    }
    @PostMapping("/delete-blog")
    public String deleteBlog(Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }
}
