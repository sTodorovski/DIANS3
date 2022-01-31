package mk.ukim.finki.dians.ehotels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HotelLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private float latitude;
    private float longitude;
    private String name;
    private String nameEN;
    private String address;
    @ManyToOne
    @JsonIgnore
    private Hotel hotel;


    public HotelLocation(float latitude, float longitude, String name, String address,Hotel hotel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
        this.hotel=hotel;
    }

    public HotelLocation() {

    }

    public String getNameEN() {
        return nameEN;
    }

    public Long getId() {
        return id;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
