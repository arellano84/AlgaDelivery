package com.algaworks.algadelivery.delivery.tracking.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStatusTest {

    @Test
    void  draft_canChangetoWaitingForCourier(){
        assertTrue(
                DeliveryStatus.DRAFT.canToChange(DeliveryStatus.WAITING_FOR_COURIER)
        );
    }
    @Test
    void  draft_canChangetoInTransit(){
        assertTrue(
                DeliveryStatus.DRAFT.canNotChangeTo(DeliveryStatus.IN_TRANSIT)
        );
    }

}