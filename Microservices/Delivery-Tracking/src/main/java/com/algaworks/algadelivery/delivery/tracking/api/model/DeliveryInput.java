package com.algaworks.algadelivery.delivery.tracking.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeliveryInput {

    @NonNull
    @Valid
    private ContactPointInput sender;

    @NonNull
    @Valid
    private ContactPointInput recipient;

    @NotEmpty
    @Valid
    @Size(min=1)
    private List<ItemInput> items;
}
