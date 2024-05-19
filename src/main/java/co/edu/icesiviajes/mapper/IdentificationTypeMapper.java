package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.IdentificationType;
import co.edu.icesiviajes.dto.IdentificationTypeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IdentificationTypeMapper {

    IdentificationTypeDTO toIdentificationTypeDTO(IdentificationType entity);

    IdentificationType toIdentificationType(IdentificationTypeDTO entity);

    List<IdentificationTypeDTO> toIdentificationTypeDTO(List<IdentificationType> entity);

    List<IdentificationType> toIdentificationType(List<IdentificationTypeDTO> entity);

}
