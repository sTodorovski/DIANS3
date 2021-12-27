package mk.ukim.finki.dians.ehotels.repository;

import mk.ukim.finki.dians.ehotels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelRepository  extends JpaRepository<Hotel,Long> {
List<Hotel> findHotelsByName(String name);
List<Hotel> findHotelByNameOrNameEN(String name,String name1);
Hotel findHotelByName(String name);



}
