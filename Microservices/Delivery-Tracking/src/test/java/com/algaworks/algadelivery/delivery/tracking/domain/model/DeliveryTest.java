package com.algaworks.algadelivery.delivery.tracking.domain.model;

import com.algaworks.algadelivery.delivery.tracking.domain.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    public void shouldChangeToPlaced() {
        Delivery delivery = Delivery.draft();
        delivery.editPrepararionDetails(createValidPreparationDetails());

        delivery.place();

        assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
        assertNotNull(delivery.getPlacedAt());
    }

    @Test
    public void shouldNotPlaced() {
        Delivery delivery = Delivery.draft();

        assertThrows(DomainException.class, () -> {
            delivery.place();
        });

        assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
        assertNull(delivery.getPlacedAt());
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