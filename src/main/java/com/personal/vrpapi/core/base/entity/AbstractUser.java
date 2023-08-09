package com.personal.vrpapi.core.base.entity;

import com.personal.vrpapi.core.authorization.entity.Gender;
import com.personal.vrpapi.core.authorization.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@FieldNameConstants
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "users")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {AbstractUser.Fields.userName})
        }
)
public abstract class AbstractUser extends AbstractEntity {

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column
    private String address;

    @Column
    private String lat;

    @Column
    private String lng;

    @Column
    private String email;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String profilePicture;

    @Column
    private Boolean isActive;

    @Column
    private Double demand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}