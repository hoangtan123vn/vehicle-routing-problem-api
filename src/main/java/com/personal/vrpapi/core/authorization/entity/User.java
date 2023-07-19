package com.personal.vrpapi.core.authorization.entity;

import com.personal.vrpapi.core.base.entity.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity(name = "users")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = User.Fields.userName)})
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldNameConstants
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column
    private Boolean isActive;

}