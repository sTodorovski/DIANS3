package mk.ukim.finki.dians.ehotels.repository;

import mk.ukim.finki.dians.ehotels.model.Hotel;
import mk.ukim.finki.dians.ehotels.model.HotelLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelLocationRepository extends JpaRepository<HotelLocation,Long> {
    List<HotelLocation> findHotelLocationsByHotel(Hotel hotel);

    List<HotelLocation> findHotelLocationsByLatitudeAndLongitude(float latitude,float longitude);
    List<HotelLocation> findHotelLocationsByAddress(String address);


}
