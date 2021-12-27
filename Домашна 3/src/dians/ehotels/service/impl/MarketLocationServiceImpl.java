package mk.ukim.finki.dians.ehotels.service.impl;

import mk.ukim.finki.dians.ehotels.model.Hotel;
import mk.ukim.finki.dians.ehotels.model.HotelLocation;
import mk.ukim.finki.dians.ehotels.repository.HotelLocationRepository;
import mk.ukim.finki.dians.ehotels.service.HotelLocationService;
import mk.ukim.finki.ehotels.eshop.service.HotelLocationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service za lokacija na hotel
 */

@Service
public class HotelLocationServiceImpl implements HotelLocationService {
    private  final HotelLocationRepository marketLocationRepository;

    /**
     * Konstruktor
     * @param hotelLocationRepository - Baza na lokacii na hotel
     */
    public HotelLocationServiceImpl(HotelLocationRepository hotelLocationRepository) {
        this.hotelLocationRepository = hotelLocationRepository;
    }

    /**
     * So ovoj metod se naogja lokacijata na hotelot spored negovoto ime,
     * Potrebno e korisnikot da go vnese imeto na hotelot
     * @param hotel - Hotelot koj treba da se prebara
     * @return -Go vrakja rezultatot od prebaruvanjeto
     */
    @Override
    public List<HotelLocation> findMarketLocationsByMarket(Hotel hotel) {
        return hotelLocationRepository.findHotelLocationsByHotel(hotel);
    }

    /**
     * Vrakja lista od lokacii na hoteli(HotelLocation) spored lat i lon prateni kako argumenti vo funkcijata
     * @param latitude - latituda na baraniot market
     * @param longitude -longituda na barantiot market
     * @return - Go vrakja rezultatot od prebaruvanjeto
     */
    @Override
    public List<HotelLocation> findHotelLocationsByLatitudeAndLongitude(float latitude, float longitude) {
        return hotelLocationRepository.findHotelLocationsByLatitudeAndLongitude(latitude,longitude);
    }

    /**
     * Vrakja lista od lokacii na hoteli (HotelLocation) spored adresata pratena kako argument vo funkcijata
     * @param address - adresa na baraniot hotel
     * @return - Go vrakja rezultatot od prebaruvanjeto
     */
    @Override
    public List<HotelLocation> findHotelsLocationByAddress(String address) {
        return hotelLocationRepository.findHotelLocationsByAddress(address);
    }

    /**
     * //Vrakja lista od site lokacii na  hoteli vo hotelLocationRepository
     * @return - Go vrakja rezultatot od prebaruvanjeto
     */
    @Override
    public List<HotelLocation> findAll() {
        return hotelLocationRepository.findAll();
    }
}
