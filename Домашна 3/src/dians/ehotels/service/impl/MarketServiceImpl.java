package mk.ukim.finki.dians.ehotels.service.impl;

import mk.ukim.finki.dians.ehotels.model.Hotel;

import mk.ukim.finki.dians.ehotels.service.HotelService;
import mk.ukim.finki.dians.ehotelsrepository.HotelRepository;
import mk.ukim.finki.dians.eshop.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service za Market
 */


@Service

public class HotelServiceImpl implements HotelService {
    private final HotelRepository HotelRepository;

    /**
     * Konstruktor
     * @param hotelRepository -Baza na Hoteli
     */
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Vrakja lista od site hoteli vo hoteltRepository
     * @return -Go vrakja rezultatot od prebaruvanjeto
     */
    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    /**
     * Vrakja lista od hoteli spored ime(name) prateno kako argument vo funkcijata
     * @param name - Ime na hotelot
     * @return -Go vrakja rezultatot od prebaruvanjeto
     */



}
