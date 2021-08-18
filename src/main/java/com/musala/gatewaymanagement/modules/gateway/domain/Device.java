package com.musala.gatewaymanagement.modules.gateway.domain;

import com.musala.gatewaymanagement.base.domain.entities.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "device")
@EntityListeners(AuditingEntityListener.class)
public class Device extends BaseEntity<Long> {

    @NotNull
    @NotBlank(message = "Vendor is mandatory")
    @Column(name = "vendor")
    private String vendor;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @NotBlank(message = "Status is mandatory")
    @Column(name = "status")
    private String status;

    @ManyToOne()
    @NotBlank(message = "Gateway is mandatory")
    @JoinColumn(name = "gateway_id", referencedColumnName = "id")
    private Gateway gateway;

}
