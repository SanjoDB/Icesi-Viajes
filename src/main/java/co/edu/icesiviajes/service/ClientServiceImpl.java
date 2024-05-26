package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.ClientDTO;
import co.edu.icesiviajes.mapper.ClientMapper;
import co.edu.icesiviajes.domain.Client;
import co.edu.icesiviajes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper mapper;

    @Override
    public List<ClientDTO> findAll() {

        List<ClientDTO> lst = mapper.toClientDTO(repository.findAll());

        return lst;
    }

    @Override
    public ClientDTO findById(Integer id) throws Exception {
        try{
            Client client = repository.findById(id).get();
            return mapper.toClientDTO(client);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public ClientDTO save(ClientDTO entity) throws Exception {

        if(repository.findById(entity.getId_client()).isEmpty()){
            Client client = mapper.toClient(entity);
            return mapper.toClientDTO(repository.save(client));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public ClientDTO update(ClientDTO entity) throws Exception {

        if(repository.findById(entity.getId_client()).isPresent()){
            Client client = mapper.toClient(entity);
            return mapper.toClientDTO(repository.save(client));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(ClientDTO entity) throws Exception {

        if(repository.findById(entity.getId_client()).isPresent()){
            Client client = mapper.toClient(entity);
            repository.delete(client);
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
    public void validate(ClientDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

    @Override
    public List<ClientDTO> listAll(String word) {
        if (word != null && !word.trim().isEmpty()) {
            return mapper.toClientDTO(repository.listAll(word));
        } else {
            return mapper.toClientDTO(repository.findAll());
        }
    }

}