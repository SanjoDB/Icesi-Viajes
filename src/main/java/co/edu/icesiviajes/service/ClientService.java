package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.ClientDTO;

import java.util.List;

public interface ClientService extends GenericService<ClientDTO, Integer>{

    List<ClientDTO> listAll(String word);

}