package com.rucreativedeveloper.comm.ecommUltra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="customer")
public class Customer {
    @Id
    @Column(name="property_id",nullable = false,length = 80)
    private String propertyId;
    @Column(name="name",length = 45,nullable = false)
    private String name;
    @Column(name="address",length = 255,nullable = false)
    private String address;
    @Column(name="phone",length = 20,nullable = false)
    private String phone;
    @Column(name="email",length = 45,nullable = false,unique = true)
    private String email;
    @Column(name="is_active",columnDefinition = "TINYINT")
    private boolean isActive;
}
