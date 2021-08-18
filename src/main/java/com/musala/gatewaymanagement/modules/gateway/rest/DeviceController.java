package com.musala.gatewaymanagement.modules.gateway.rest;


import com.musala.gatewaymanagement.modules.gateway.services.DeviceService;
import com.musala.gatewaymanagement.modules.gateway.services.dto.DeviceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping()
    public List<DeviceDto> findAllByGatewayId(@RequestParam(value = "gatewayId") Long gatewayId) {
        return deviceService.findAllByGatewayId(gatewayId);
    }

    @GetMapping("/{deviceId}")
    public DeviceDto findById(@PathVariable("deviceId") Long deviceId) {
        return deviceService.findById(deviceId);
    }

    @PostMapping()
    public void save(@Valid @RequestBody DeviceDto dto) {
        deviceService.save(dto);
    }

    @PutMapping("/{deviceId}")
    public void update(@PathVariable Long deviceId, @RequestBody DeviceDto dto) {
        deviceService.update(deviceId, dto);
    }

    @DeleteMapping("/{deviceId}")
    public void delete(@PathVariable Long deviceId) {
        deviceService.delete(deviceId);
    }
}
