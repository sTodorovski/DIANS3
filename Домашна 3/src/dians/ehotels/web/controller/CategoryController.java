package mk.ukim.finki.dians.ehotels.web.controller;

import mk.ukim.finki.dians.ehotels.model.Category;
import mk.ukim.finki.dians.ehotels.model.User;
import mk.ukim.finki.dians.ehotels.repository.UserRepository;
import mk.ukim.finki.dians.ehotels.service.AuthService;
import mk.ukim.finki.dians.ehotels.service.CategoryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Ovoj kontroler ima za cel da prebara odreden hotel po izbranata kategorija.
 * Se prebaruva i na makedonski i na angliski jazik, vo zavisnost sto korisnikot odbral.
 */

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    private final AuthService authService;
    private final UserRepository userRepository;
    public CategoryController(CategoryService categoryService, AuthService authService, UserRepository userRepository) {
        this.categoryService = categoryService;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{category}")
    public String getCategoryPage(@PathVariable String category, Model model,@RequestParam(required = false) String language,HttpServletRequest request){

        if(language==null) {
            language="MK";
        }


            model.addAttribute("language", language);


        Category category1 = categoryService.findCategoryByName(language,category);

        model.addAttribute("category", category1);
        model.addAttribute("products", categoryService.findProductsByCategory(category1.getName()));

String c="";
        if(language.equals("MK")) {
            model.addAttribute("newurl", "/category/" + category1.getNameEN() + "?language=EN");
            c=category1.getName();
        }else {
            model.addAttribute("newurl", "/category/" + category1.getName() + "?language=MK");
        c=category1.getNameEN();
        }
        model.addAttribute("url","/category/"+c+"?language="+language);
        if(request.getRemoteUser()!=null){
            model.addAttribute("user",userRepository.findByUsername(request.getRemoteUser()));
        }

        model.addAttribute("bodyContent","category");
        return "master-template";






    }
    @PostMapping("/{category}")
    public String getResultsCategory(@RequestParam String language, HttpServletRequest request, @PathVariable String category){
        request.getSession().setAttribute("products",productService.searchByProducts(request.getParameter("search")));
        return "redirect:/search?language="+language;

    }

}
