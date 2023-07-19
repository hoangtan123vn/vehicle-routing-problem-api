package com.personal.vrpapi.core.authorization.entity;

import com.personal.vrpapi.core.authorization.enums.RoleEnum;
import com.personal.vrpapi.core.base.entity.AbstractEntity;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity {

    public Role(RoleEnum role) {
        this.roleName = role;
    }

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;

    @OneToMany(mappedBy = User.Fields.role, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}