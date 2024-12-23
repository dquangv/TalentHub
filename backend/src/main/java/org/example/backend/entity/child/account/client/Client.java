package org.example.backend.entity.child.account.client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.User;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AbstractEntity<Long> {

    @Column(name = "from_price")
    private Double fromPrice;

    @Column(name = "to_price")
    private Double toPrice;

    @Column(name = "type_price")
    private String typePrice;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
