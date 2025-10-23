package org.ahmed.ecom.entities;

import jakarta.persistence.*;
import lombok.*;
import org.ahmed.ecom.enums.PaymentMethod;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
//used to listen to jpa event and react to them generally by logging some messages useful for auditing our table
//jpa events like preRemove PrePersist PostLoad ...
//article : https://www.baeldung.com/jpa-entity-lifecycle-events
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true,  nullable = false)
    private String reference;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    //used for auditing
    // when an entity is created The createdDate field is automatically populated with the current timestamp
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;
    //Spring Data JPA automatically updates this field whenever the entity is modified and saved
    @LastModifiedDate
    //Ensures this column is not explicitly set when the entity is first inserted. It will only be updated when changes are made to the entity after creation
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}