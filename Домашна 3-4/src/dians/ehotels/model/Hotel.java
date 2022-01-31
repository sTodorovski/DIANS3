package mk.ukim.finki.dians.ehotels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    @OneToMany(mappedBy="hotel")
    @JsonIgnore
    List<Product> products;
    @JsonIgnore
    private  String imageUrl;
    private String nameEN;

    public Hotel(Long id, String name , List<Product> products, String imageUrl,String nameEN) {
        this.id = id;
        this.nameEN=nameEN;
        this.name = name;
        this.products = products;
        this.imageUrl = imageUrl;
    }

    public Hotel() {
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public List<Product> getProducts(){
        return products;
    }

}
