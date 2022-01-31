package mk.ukim.finki.dians.ehotels.service;

import mk.ukim.finki.dians.ehotels.model.Hotel;
import mk.ukim.finki.dians.ehotels.model.HotelLocation;

import java.util.List;

public interface HotelLocationService {

    List<HotelLocation> findMarketLocationsByMarket(Market market);
   List<HotelLocation> findHotelLocationsByLatitudeAndLongitude(float latitude, float longitude);
    List<HotelLocation> findHotelsLocationByAddress(String address);

    List<HotelLocationService> findAll();
}
