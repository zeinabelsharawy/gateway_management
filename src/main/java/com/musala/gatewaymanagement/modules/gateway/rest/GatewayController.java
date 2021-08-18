package com.musala.gatewaymanagement.modules.gateway.rest;

import com.musala.gatewaymanagement.modules.gateway.services.GatewayService;
import com.musala.gatewaymanagement.modules.gateway.services.dto.GatewayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gateways")
public class GatewayController {

    private final GatewayService gatewayService;

    @GetMapping()
    public List<GatewayDto> findAll() {
        return gatewayService.findAll();
    }

    @GetMapping("/{gatewayId}")
    public GatewayDto findById(@PathVariable Long gatewayId) {
        return gatewayService.findById(gatewayId);
    }

    @PostMapping()
    public void save(@RequestBody GatewayDto dto) {
        gatewayService.save(dto);
    }

    @PutMapping("/{gatewayId}")
    public void update(@PathVariable Long gatewayId, @RequestBody GatewayDto dto) {
        gatewayService.update(gatewayId, dto);
    }

    @DeleteMapping("/{gatewayId}")
    public void delete(@PathVariable Long gatewayId) {
        gatewayService.delete(gatewayId);
    }
}
