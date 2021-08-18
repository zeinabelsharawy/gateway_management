package com.musala.gatewaymanagement.modules.gateway.domain;

import com.musala.gatewaymanagement.base.domain.entities.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gateway")
public class Gateway extends BaseEntity<Long> {

    @Column(name = "serial_number")
    private String serialNumber;

    @NotNull
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank(message = "IPV4 is mandatory")
    @Column(name = "ipv4")
    private String ipv4;

    @OneToMany(mappedBy = "gateway", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Device> devices = new HashSet<>();
}
