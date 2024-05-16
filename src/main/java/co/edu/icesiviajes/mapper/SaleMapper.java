package co.edu.icesiviajes.mapper;

import co.edu.icesiviajes.domain.Sale;
import co.edu.icesiviajes.dto.SaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SaleMapper {

    @Mapping(source = "client.id_client", target = "client")
    @Mapping(source = "plan.id_plan", target = "plan")
    SaleDTO toSaleDTO(Sale entity);

    @Mapping(source = "client", target = "client.id_client")
    @Mapping(source = "plan", target = "plan.id_plan")
    Sale toSale(SaleDTO entity);

    @Mapping(source = "client.id_client", target = "client")
    @Mapping(source = "plan.id_plan", target = "plan")
    List<SaleDTO> toSaleDTO(List<Sale> entity);

    @Mapping(source = "client", target = "client.id_client")
    @Mapping(source = "plan", target = "plan.id_plan")
    List<Sale> toSale(List<SaleDTO> entity);

}
