package com.musala.gatewaymanagement.modules.gateway.services.dto;

import com.musala.gatewaymanagement.modules.gateway.domain.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DeviceDto {

    private String vendor;
    private LocalDateTime createdAt;
    private String status;
    private Long gatewayId;

    public DeviceDto(Device device) {
        this.vendor = device.getVendor();
        this.createdAt = device.getCreatedAt();
        this.status = device.getStatus();
        this.gatewayId = device.getGateway().getId();
    }


}
