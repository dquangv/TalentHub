package org.example.backend.entity.child;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;
import org.example.backend.entity.AbstractEntity;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AbstractEntity<Long> {

    @Column(name = "form_price")
    private Double formPrice;

    @Column(name = "to_price")
    private Double toPrice;

    @Column(name = "type_price")
    private String typePrice;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
