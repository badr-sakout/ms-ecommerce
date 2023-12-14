package org.sid.orderservice.entities;


import jakarta.persistence.*;
import lombok.*;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;


import java.util.Date;
import java.util.List;

@Entity
@Table(name ="orders")
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Order {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getotal(){
        double somme=0;
        for (ProductItem pi:productItems){
            somme+= pi.getAmount();
        }
        return somme;
    }

}
