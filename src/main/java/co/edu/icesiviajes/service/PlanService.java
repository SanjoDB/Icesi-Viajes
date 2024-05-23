package co.edu.icesiviajes.service;

import co.edu.icesiviajes.dto.PlanDTO;

import java.util.List;

public interface PlanService extends GenericService<PlanDTO, Integer>{

    List<PlanDTO> listAll(String word);

}