package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.ReservationDTO;

import java.util.List;

public interface ReservationService extends GenericService<ReservationDTO, Integer>{

    List<ReservationDTO> findByClientID(Integer id);

    List<ReservationDTO> findByPlanID(Integer id);

    ReservationDTO findByClientIDAndPlanID(Integer clientId, Integer planId);

    void deleteByClientID(Integer id);

    void deleteByPlanID(Integer id);

    List<Object> findWeeklyReservations();

    List<Object[]> findLatestReservations();

}