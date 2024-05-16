package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.domain.Reservation;
import co.edu.icesiviajes.dto.ReservationDTO;
import co.edu.icesiviajes.mapper.ReservationMapper;
import co.edu.icesiviajes.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public List<ReservationDTO> findAll() {

        List<ReservationDTO> lstCliente = reservationMapper.toReservationDTO(reservationRepository.findAll());

        return lstCliente;
    }

    @Override
    public ReservationDTO findById(Integer id) throws Exception {
        try{
            Reservation reservation = reservationRepository.findById(id).get();
            return reservationMapper.toReservationDTO(reservation);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public ReservationDTO save(ReservationDTO entity) throws Exception {

        Reservation reservation = reservationMapper.toReservation(entity);

        if(reservationRepository.findById(reservation.getId_reservation()).isEmpty()){
            return reservationMapper.toReservationDTO(reservationRepository.save(reservation));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public ReservationDTO update(ReservationDTO entity) throws Exception {

        Reservation reservation = reservationMapper.toReservation(entity);

        if(reservationRepository.findById(reservation.getId_reservation()).isPresent()){
            return reservationMapper.toReservationDTO(reservationRepository.save(reservation));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(ReservationDTO entity) throws Exception {

        Reservation reservation = reservationMapper.toReservation(entity);

        if(reservationRepository.findById(reservation.getId_reservation()).isPresent()){
            reservationRepository.delete(reservation);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            Reservation reservation = reservationRepository.findById(id).get();
            reservationRepository.deleteById(reservation.getId_reservation());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(ReservationDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return reservationRepository.count();

    }

}
