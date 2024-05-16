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
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> findAll() {

        List<ClientDTO> lstCliente = clientMapper.toClientDTO(clientRepository.findAll());

        return lstCliente;
    }

    @Override
    public ClientDTO findById(Integer id) throws Exception {
        try{
            Client client = clientRepository.findById(id).get();
            return clientMapper.toClientDTO(client);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public ClientDTO save(ClientDTO entity) throws Exception {

        Client client = clientMapper.toClient(entity);

        if(clientRepository.findById(client.getId_client()).isEmpty()){
            return clientMapper.toClientDTO(clientRepository.save(client));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public ClientDTO update(ClientDTO entity) throws Exception {

        Client client = clientMapper.toClient(entity);

        if(clientRepository.findById(client.getId_client()).isPresent()){
            return clientMapper.toClientDTO(clientRepository.save(client));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(ClientDTO entity) throws Exception {

        Client client = clientMapper.toClient(entity);

        if(clientRepository.findById(client.getId_client()).isPresent()){
            clientRepository.delete(client);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            Client client = clientRepository.findById(id).get();
            clientRepository.deleteById(client.getId_client());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(ClientDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return clientRepository.count();

    }

}