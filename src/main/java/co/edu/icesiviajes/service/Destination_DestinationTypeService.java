package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.Destination_DestinationTypeDTO;

import java.util.List;

public interface Destination_DestinationTypeService extends GenericService<Destination_DestinationTypeDTO, Integer> {

    List<Destination_DestinationTypeDTO> findByDestinationID(Integer id);

    List<Destination_DestinationTypeDTO> findByDestinationTypeID(Integer id);

    Destination_DestinationTypeDTO findByDestinationIDAndDestinatioTypeID(Integer desId, Integer desTyId);

    void deleteByDestinationID(Integer id);

    void deleteByDestinationTypeID(Integer id);

}