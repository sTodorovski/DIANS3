package mk.ukim.finki.dians.ehotels.web.controller;

import mk.ukim.finki.dians.ehotels.model.Category;
import mk.ukim.finki.dians.ehotels.model.User;
import mk.ukim.finki.dians.ehotels.service.CategoryService;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/** Vo CategoriesController se naogjaat servisi za kategorija i produkt
 * Ovoj kontroler gi "kontrolira" kategoriite spored odbraniot jazik(makedonski i angliski) vo delot kaj sto se prebaruvaat istite.
 */

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryServic) {
        this.categoryService = categoryService;

    }

    @GetMapping
    public String getPage(@RequestParam(required = false) String language, Model model,HttpServletRequest request){
        if(language==null){
            language="MK";
        }
        model.addAttribute("language",language);
        model.addAttribute("categories",categoryService.listAll());
       if(language.equals("MK")){
           model.addAttribute("newurl","/categories?language=EN");

       }
       else{
           model.addAttribute("newurl","/categories?language=MK");
       }
        model.addAttribute("url","/categories?language="+language);

        model.addAttribute("bodyContent","categories");
        return "master-template";



}
@PostMapping
public String getResults(@RequestParam String language, Model model, HttpServletRequest request){

        request.getSession().setAttribute("products",productService.searchByProducts(request.getParameter("search")));
return "redirect:/search?language="+language;



}






}
