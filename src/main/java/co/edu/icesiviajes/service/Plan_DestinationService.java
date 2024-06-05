package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.Plan_DestinationDTO;

import java.util.List;

public interface Plan_DestinationService extends GenericService<Plan_DestinationDTO, Integer>{

    List<Plan_DestinationDTO> findByPlanID(Integer id);

    List<Plan_DestinationDTO> findByDestinationID(Integer id);

    Plan_DestinationDTO findByPlanIDAndDestinatioID(Integer planId, Integer desId);

    void deleteByPlanID(Integer id);

    void deleteByDestinationID(Integer id);

}