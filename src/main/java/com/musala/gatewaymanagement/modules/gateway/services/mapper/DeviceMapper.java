package com.musala.gatewaymanagement.modules.gateway.services.mapper;

import com.musala.gatewaymanagement.modules.gateway.domain.Device;
import com.musala.gatewaymanagement.modules.gateway.domain.repository.GatewayRepository;
import com.musala.gatewaymanagement.modules.gateway.services.dto.DeviceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DeviceMapper {

    private final GatewayRepository gatewayRepository;

    public DeviceDto toDto(Device entity) {
        return new DeviceDto(entity);
    }

    public List<DeviceDto> toDto(List<Device> entities) {
        return entities.stream().map(DeviceDto::new).collect(Collectors.toList());
    }

    public Device toEntity(DeviceDto DeviceDto) {
        return toEntity(DeviceDto, new Device());
    }

    public Device toEntity(DeviceDto dto, Device entity) {
        entity.setVendor(dto.getVendor());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setStatus(dto.getStatus());
        entity.setStatus(dto.getStatus());

        entity.setGateway(gatewayRepository.findById(dto.getGatewayId()).orElseThrow());
        return entity;
    }
}
