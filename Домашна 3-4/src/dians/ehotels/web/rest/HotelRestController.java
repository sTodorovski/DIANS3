package mk.ukim.finki.dians.ehotels.web.rest;



import mk.ukim.finki.dians.ehotels.model.Hotel;
import mk.ukim.finki.dians.ehotels.model.HotelLocation;
import mk.ukim.finki.dians.ehotels.model.Product;
import mk.ukim.finki.dians.ehotels.service.HotelLocationService;
import mk.ukim.finki.dians.ehotels.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class HotelRestController {
        private final HotelService hotelService;
        private final HotelLocationService hotelLocationService;

        public HotelRestController(hotelService hotelService, HotelLocationService hotelLocationService) {
            this.marketService = marketService;

            this.hotelLocationService = hotelLocationService;
        }

        @GetMapping("/markets")
        public List<Hotel> getHotels() {
            return hotelService.findAll();

        }


        @GetMapping("/hotels/{hotel}")
        public List<Product> getProductsByHotel(@PathVariable String hotel) {
            return hotelService.findProductsByHotel(hotel);
        }

        @GetMapping("/hotellocations/{hotel}")
        public List<HotelLocation> getLocations(@PathVariable String hotel) {
            if(hotelService.findMHotelsByName(hotel).isEmpty())
                return new  ArrayList<>();
            return hotelLocationService.findHotelLocationsByHotel(hotelService.findHotelsByName(hotel).get(0));
        }
    }


}
