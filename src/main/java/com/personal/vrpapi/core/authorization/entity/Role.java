package com.personal.vrpapi.core.authorization.entity;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.entity.AbstractEntity;
import com.personal.vrpapi.core.base.entity.AbstractUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = Role.Fields.roleName) })
@FieldNameConstants
@Getter
@Setter
@NoArgsConstructor
public class Role extends AbstractEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = AbstractUser.Fields.role)
    private List<AbstractUser> users = new ArrayList<>();
}