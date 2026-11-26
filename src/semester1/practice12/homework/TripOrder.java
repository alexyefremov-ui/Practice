package semester1.practice12.homework;

import java.util.Objects;

public class TripOrder {
    private final String orderId;
    private final String fromCity;
    private final String toCity;
    private final Transport transport;

    public TripOrder(String orderId, String fromCity, String toCity, Transport transport) {
        if (transport == null) {
            throw new IllegalArgumentException("Транспорт не може бути null");
        }
        this.orderId = orderId;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.transport = transport;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TripOrder other)) {
            return false;
        }
        return Objects.equals(orderId, other.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
