package mk.ukim.finki.dians.ehotels.web.controller;

import mk.ukim.finki.dians.ehotels.service.MarketService;
import mk.ukim.finki.dians.ehotels.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/")
public class HomeController {
    //Se generira interface za prebaruvanje na hoteli(biznis logika).
    private final HotelService hotelService;



    /**
     * Konstruktor
     * @param hotelService - interface za prebaruvanje na hoteli.

     */
    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;

    }

    /**
     * Se dobiva pochetnata strana so izbraniot jazik.
     * @param language - Jazikot na koj sto treba da se prikaze stranata.
     * @param model -  Promenliva koja sto gi sodrzi atributite na modelot na stranata.
     * @param request - HttpServletRequest objekt koj go prenesuva baranjeto za odredena strana do metodot.
     * @return - Go vrakja glavniot shablon na stranata, preureden spored atributite.
     */
    @GetMapping
    public String getHomePage(@RequestParam(required = false) String language, Model model,HttpServletRequest request){
        if(language==null)
            language="MK";
        model.addAttribute("markets",marketService.findAll());
        model.addAttribute("language",language);
        model.addAttribute("bodyContent","home");
        if(language.equals("MK"))
        model.addAttribute("newurl","/?language=EN");
        else
            model.addAttribute("newurl","/?language=MK");
        model.addAttribute("url","/?language="+language);
        request.getSession().setAttribute("language",language);
        model.addAttribute("bestProducts",shoppingCartService.getMostBoughtProducts());

        return "master-template";
    }

    /**
     * Se dobiva produkti spored vnesenata vrednost vo poleto za prebaruvanje.
     * @param language - Jazikot na koj sto treba da se prikaze stranata.
     * @param search - String spored koj se prebaruva za produkt.
     * @param request - HttpServletRequest objekt koj go prenesuva baranjeto za odredena strana do metodot.
     * @return - Go vrakja rezultatot od prebaruvanjeto.
     */
    @PostMapping
    public String search(@RequestParam String language, @RequestParam String search, HttpServletRequest request){


        request.getSession().setAttribute("products",productService.searchByProducts(search));
        return "redirect:/search?language="+language;

    }
}
