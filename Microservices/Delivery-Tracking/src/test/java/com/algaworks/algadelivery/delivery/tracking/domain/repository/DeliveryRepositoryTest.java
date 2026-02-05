package com.algaworks.algadelivery.delivery.tracking.domain.repository;

import com.algaworks.algadelivery.delivery.tracking.domain.model.ContactPoint;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void shoudPersist() {
        Delivery delivery = Delivery.draft();

        delivery.editPrepararionDetails(createValidPreparationDetails());

        delivery.addItems("Computador", 2);
        delivery.addItems("Notebook", 2);

        deliveryRepository.saveAndFlush(delivery);

        Delivery persistedDelivery = deliveryRepository.findById(delivery.getId()).orElseThrow();

        assertEquals(2, persistedDelivery.getItems().size());
    }

    private Delivery.PreparationDetails createValidPreparationDetails() {

        ContactPoint sender = ContactPoint.builder()
                .zipCode("00000-000")
                .street("Rua Sao Paulo")
                .number("100")
                .name("Joao Silva")
                .phone("(00) 00000-0000")
                .build();

        ContactPoint recipient = ContactPoint.builder()
                .zipCode("11111-111")
                .street("Rua Brasil")
                .number("200")
                .name("Maria Silva")
                .phone("(11) 11111-1111")
                .build();

        return Delivery.PreparationDetails.builder()
                .sender(sender)
                .recipiet(recipient)
                .distanceFee(new BigDecimal("15.00"))
                .courierPayout(new BigDecimal("5.00"))
                .expectedDeliveryTime(Duration.ofHours(5))
                .build();
    }
}