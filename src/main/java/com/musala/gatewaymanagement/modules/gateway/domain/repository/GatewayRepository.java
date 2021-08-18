package com.musala.gatewaymanagement.modules.gateway.domain.repository;


import com.musala.gatewaymanagement.modules.gateway.domain.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, Long> {

}
