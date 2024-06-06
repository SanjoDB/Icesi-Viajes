package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.SaleDTO;

import java.util.List;

public interface SaleService extends GenericService<SaleDTO, Integer>{

    List<SaleDTO> findByClientID(Integer id);

    List<SaleDTO> findByPlanID(Integer id);

    SaleDTO findByClientIDAndPlanID(Integer clientId, Integer planId);

    void deleteByClientID(Integer id);

    void deleteByPlanID(Integer id);

}