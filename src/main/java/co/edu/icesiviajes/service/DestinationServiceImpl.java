package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Destination;
import co.edu.icesiviajes.dto.DestinationDTO;
import co.edu.icesiviajes.mapper.DestinationMapper;
import co.edu.icesiviajes.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class DestinationServiceImpl implements DestinationService{

    @Autowired
    private DestinationRepository destinationRepository;
    @Autowired
    private DestinationMapper destinationMapper;

    @Override
    public List<DestinationDTO> findAll() {

        List<DestinationDTO> lstCliente = destinationMapper.toDestinationDTO(destinationRepository.findAll());

        return lstCliente;
    }

    @Override
    public DestinationDTO findById(Integer id) throws Exception {
        try{
            Destination destination = destinationRepository.findById(id).get();
            return destinationMapper.toDestinationDTO(destination);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public DestinationDTO save(DestinationDTO entity) throws Exception {

        Destination destination = destinationMapper.toDestination(entity);

        if(destinationRepository.findById(destination.getId_destination()).isEmpty()){
            return destinationMapper.toDestinationDTO(destinationRepository.save(destination));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public DestinationDTO update(DestinationDTO entity) throws Exception {

        Destination destination = destinationMapper.toDestination(entity);

        if(destinationRepository.findById(destination.getId_destination()).isPresent()){
            return destinationMapper.toDestinationDTO(destinationRepository.save(destination));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(DestinationDTO entity) throws Exception {

        Destination destination = destinationMapper.toDestination(entity);

        if(destinationRepository.findById(destination.getId_destination()).isPresent()){
            destinationRepository.delete(destination);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            Destination destination = destinationRepository.findById(id).get();
            destinationRepository.deleteById(destination.getId_destination());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(DestinationDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return destinationRepository.count();

    }

}
