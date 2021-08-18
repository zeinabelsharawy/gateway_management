package com.musala.gatewaymanagement.modules.gateway.domain.repository;

import com.musala.gatewaymanagement.modules.gateway.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Transactional(readOnly = true)
    List<Device> findAllByGatewayId(Long gatewayId);
}
