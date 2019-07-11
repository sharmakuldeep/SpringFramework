package sharma.springframework.spring5webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sharma.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
       return "authors";
    }
}
