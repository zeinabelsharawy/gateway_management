package com.musala.gatewaymanagement.modules.gateway.services;


import com.musala.gatewaymanagement.base.exception.MaxNumOfDevicesExceededException;
import com.musala.gatewaymanagement.modules.gateway.domain.Device;
import com.musala.gatewaymanagement.modules.gateway.domain.repository.DeviceRepository;
import com.musala.gatewaymanagement.modules.gateway.services.dto.DeviceDto;
import com.musala.gatewaymanagement.modules.gateway.services.mapper.DeviceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;

    public List<DeviceDto> findAll() {
        return deviceMapper.toDto(deviceRepository.findAll());
    }

    public DeviceDto findById(Long id) {
        return deviceMapper.toDto(deviceRepository.findById(id).orElseThrow());
    }

    public List<DeviceDto> findAllByGatewayId(Long gatewayId) {
        return deviceMapper.toDto(deviceRepository.findAllByGatewayId(gatewayId));
    }

    public void save(DeviceDto dto) {
        long gatewayID = dto.getGatewayId();
        if (deviceRepository.findAllByGatewayId(gatewayID).size() > 10) {
            throw new MaxNumOfDevicesExceededException("no more than 10 peripheral devices are allowed for a gateway");
        }
        deviceRepository.save(deviceMapper.toEntity(dto));
    }

    public void update(Long id, DeviceDto dto) {
        Device device = deviceRepository.findById(id).orElseThrow();
        deviceMapper.toEntity(dto, device);
        deviceRepository.save(device);
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
