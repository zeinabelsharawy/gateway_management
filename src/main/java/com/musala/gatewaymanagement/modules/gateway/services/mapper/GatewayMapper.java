package com.musala.gatewaymanagement.modules.gateway.services.mapper;

import com.musala.gatewaymanagement.modules.gateway.domain.Gateway;
import com.musala.gatewaymanagement.modules.gateway.services.dto.GatewayDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GatewayMapper {

    public GatewayDto toDto(Gateway category) {
        return new GatewayDto(category);
    }

    public List<GatewayDto> toDto(List<Gateway> categories) {
        return categories.stream().map(GatewayDto::new).collect(Collectors.toList());
    }

    public Gateway toEntity(GatewayDto gatewayDto) {
        return toEntity(gatewayDto, new Gateway());
    }

    public Gateway toEntity(GatewayDto dto, Gateway entity) {
        entity.setName(dto.getName());
//        entity.setSerialNumber(dto.getSerialNumber());
        entity.setIpv4(dto.getIpv4());
        return entity;
    }
}
