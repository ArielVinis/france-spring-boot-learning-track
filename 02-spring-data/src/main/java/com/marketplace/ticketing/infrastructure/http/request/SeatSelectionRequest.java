package com.marketplace.ticketing.infrastructure.http.request;

import com.marketplace.ticketing.domain.SeatId;

public record SeatSelectionRequest(String id) {
    public SeatId toInput() {
        return new SeatId(id);
    }
}
