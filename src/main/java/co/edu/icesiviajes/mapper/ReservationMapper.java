package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Reservation;
import co.edu.icesiviajes.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ReservationMapper {

    @Mapping(source = "client.id_client", target = "client")
    @Mapping(source = "plan.id_plan", target = "plan")
    ReservationDTO toReservationDTO(Reservation entity);

    @Mapping(source = "client", target = "client.id_client")
    @Mapping(source = "plan", target = "plan.id_plan")
    Reservation toReservation(ReservationDTO entity);

    @Mapping(source = "client.id_client", target = "client")
    @Mapping(source = "plan.id_plan", target = "plan")
    List<ReservationDTO> toReservationDTO(List<Reservation> entity);

    @Mapping(source = "client", target = "client.id_client")
    @Mapping(source = "plan", target = "plan.id_plan")
    List<Reservation> toReservation(List<ReservationDTO> entity);

}
