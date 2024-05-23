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
    private ReservationRepository repository;
    @Autowired
    private ReservationMapper mapper;

    @Override
    public List<ReservationDTO> findAll() {

        List<ReservationDTO> lst = mapper.toReservationDTO(repository.findAll());

        return lst;
    }

    @Override
    public ReservationDTO findById(Integer id) throws Exception {
        try{
            Reservation reservation = repository.findById(id).get();
            return mapper.toReservationDTO(reservation);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public ReservationDTO save(ReservationDTO entity) throws Exception {

        if(repository.findById(entity.getId_reservation()).isEmpty()){
            Reservation reservation = mapper.toReservation(entity);
            return mapper.toReservationDTO(repository.save(reservation));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public ReservationDTO update(ReservationDTO entity) throws Exception {

        if(repository.findById(entity.getId_reservation()).isPresent()){
            Reservation reservation = mapper.toReservation(entity);
            return mapper.toReservationDTO(repository.save(reservation));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(ReservationDTO entity) throws Exception {

        if(repository.findById(entity.getId_reservation()).isPresent()){
            Reservation reservation = mapper.toReservation(entity);
            repository.delete(reservation);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(ReservationDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

}
