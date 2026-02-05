package com.algaworks.algadelivery.delivery.tracking.domain.model;


import java.util.Arrays;
import java.util.List;

public enum DeliveryStatus {
    DRAFT,
    WAITING_FOR_COURIER(DRAFT),
    IN_TRANSIT(WAITING_FOR_COURIER),
    DELIVERED(IN_TRANSIT);

    private final List<DeliveryStatus> previusStatuses;

    DeliveryStatus(DeliveryStatus... previusStatuses) {
        this.previusStatuses = Arrays.asList(previusStatuses);
    }

    public boolean canNotChangeTo(DeliveryStatus newStatus) {
        DeliveryStatus current = this;
        return !newStatus.previusStatuses.contains(current);
    }

    public boolean canToChange(DeliveryStatus newStatus){
        return !canNotChangeTo(newStatus);
    }
}
