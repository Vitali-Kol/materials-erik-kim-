package ee.spring.materials.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    private int id;
    private String name;
    private double price;
    private boolean active;
}
