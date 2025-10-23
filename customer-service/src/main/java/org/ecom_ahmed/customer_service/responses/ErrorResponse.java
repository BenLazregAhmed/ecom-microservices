package org.ecom_ahmed.customer_service.responses;

import java.util.Map;

public record ErrorResponse(
        Map<String,String>errors
) {
}
