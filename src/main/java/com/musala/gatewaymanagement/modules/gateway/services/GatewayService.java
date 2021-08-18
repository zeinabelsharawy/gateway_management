package com.musala.gatewaymanagement.modules.gateway.services;


import com.musala.gatewaymanagement.base.exception.InvalidInputsException;
import com.musala.gatewaymanagement.modules.gateway.domain.Gateway;
import com.musala.gatewaymanagement.modules.gateway.domain.repository.GatewayRepository;
import com.musala.gatewaymanagement.modules.gateway.services.dto.GatewayDto;
import com.musala.gatewaymanagement.modules.gateway.services.mapper.GatewayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GatewayService {
    private final int MIN = 50;
    private final int MAX = 100;

    private final GatewayMapper gatewayMapper;
    private final GatewayRepository gatewayRepository;

    public List<GatewayDto> findAll() {
        return gatewayMapper.toDto(gatewayRepository.findAll());
    }

    public GatewayDto findById(Long id) {
        return gatewayMapper.toDto(gatewayRepository.findById(id).orElseThrow());
    }

    public void save(GatewayDto dto) {
        Gateway gateway = gatewayMapper.toEntity(dto);
        validateInputs(gateway);
        gateway.setSerialNumber(getRandomSerialNumber());
        gatewayRepository.save(gateway);
    }

    public void update(Long id, GatewayDto dto) {
        Gateway category = gatewayRepository.findById(id).orElseThrow();
        gatewayMapper.toEntity(dto, category);
        gatewayRepository.save(category);
    }

    public void delete(Long id) {
        gatewayRepository.deleteById(id);
    }

    private String getRandomSerialNumber() {
        int randomInt = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        return (Calendar.getInstance().getTimeInMillis() + randomInt) + "";
    }

    private void validateInputs(Gateway gateway) {
        if (gateway.getIpv4() == null || gateway.getIpv4().isEmpty()) {
            throw new InvalidInputsException("IPV4 is mandatory");
        }
        if (gateway.getName() == null || gateway.getName().isEmpty()) {
            throw new InvalidInputsException("Name is mandatory");
        }
    }
}
