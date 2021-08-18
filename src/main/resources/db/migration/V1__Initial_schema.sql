/*
* Gateway Table
*/
CREATE TABLE gateway
(
    id      BIGINT NOT NULL AUTO_INCREMENT,
    serial_number VARCHAR UNIQUE NOT NULL,
    name    VARCHAR NOT NULL,
    ipv4    VARCHAR NOT NULL,
    version INTEGER NOT NULL,
    CONSTRAINT PK_GATEWAY PRIMARY KEY (id)
) ENGINE = InnoDB;

/*
* Device Table
*/
CREATE TABLE device
(
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    vendor     VARCHAR  NOT NULL,
    created_at  DATETIME NOT NULL,
    status     VARCHAR  NOT NULL,
    gateway_id BIGINT   NOT NULL,
    version    INTEGER  NOT NULL,
    CONSTRAINT PK_DEVICE PRIMARY KEY (id),
    CONSTRAINT FK_Device_Gateway FOREIGN KEY (gateway_id) REFERENCES gateway (id)
) ENGINE = InnoDB;


/*
* CREATE Gateway
*/
INSERT INTO gateway(serial_number, name, ipv4, version)
values ('1629231770129', 'GW', '192.168.1.1', 0);
SET @gatewayId = LAST_INSERT_ID();

INSERT INTO gateway(serial_number, name, ipv4, version)
values ('1629231770130', 'GW1', '192.168.1.1', 0);
SET @gatewayId = LAST_INSERT_ID();
/*
* CREATE Device
*/
INSERT INTO device(vendor, created_at, status, gateway_id, version)
values ('cisco', '2020-03-17 07:13:30', 'online', 1, 0);

INSERT INTO device(vendor, created_at, status, gateway_id, version)
values ('ibm', '2020-03-17 08:13:30', 'online', 1, 0);

INSERT INTO device(vendor, created_at, status, gateway_id, version)
values ('ibm', '2020-03-17 08:13:30', 'online', 2, 0);
