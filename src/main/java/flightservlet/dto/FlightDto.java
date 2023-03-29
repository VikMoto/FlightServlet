package flightservlet.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FlightDto {
    Long id;
    String description;
}
//
//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
//@Value - replace private final
//private final Long id;
//    private final String description;