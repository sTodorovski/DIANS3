package mk.ukim.finki.dians.ehotels.service;

import mk.ukim.finki.dians.ehotels.model.Market;


import java.util.List;

public interface HotelService {
    public List<Hotel> findAll();
    public List<Hotel> findMarketsByName(String name);



}
