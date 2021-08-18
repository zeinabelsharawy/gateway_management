package com.musala.gatewaymanagement.modules.gateway.services.dto;

import com.musala.gatewaymanagement.modules.gateway.domain.Gateway;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GatewayDto {
    private long id;
    private String serialNumber;
    private String name;
    private String ipv4;


    public GatewayDto(Gateway gateway) {
        this.id = gateway.getId();
        this.serialNumber = gateway.getSerialNumber();
        this.name = gateway.getName();
        this.ipv4 = gateway.getIpv4();
    }
}
