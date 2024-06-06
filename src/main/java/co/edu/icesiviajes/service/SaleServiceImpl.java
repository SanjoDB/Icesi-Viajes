package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Sale;
import co.edu.icesiviajes.dto.ReservationDTO;
import co.edu.icesiviajes.dto.SaleDTO;
import co.edu.icesiviajes.mapper.SaleMapper;
import co.edu.icesiviajes.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope("singleton")
@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository repository;
    @Autowired
    private SaleMapper mapper;

    @Override
    public List<SaleDTO> findAll() {

        List<SaleDTO> lst = mapper.toSaleDTO(repository.findAll());

        return lst;
    }

    @Override
    public SaleDTO findById(Integer id) throws Exception {
        try{
            Sale sale = repository.findById(id).get();
            return mapper.toSaleDTO(sale);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public SaleDTO save(SaleDTO entity) throws Exception {

        if(repository.findById(entity.getId_sale()).isEmpty()){
            Sale sale = mapper.toSale(entity);
            return mapper.toSaleDTO(repository.save(sale));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public SaleDTO update(SaleDTO entity) throws Exception {

        if(repository.findById(entity.getId_sale()).isPresent()){
            Sale sale = mapper.toSale(entity);
            return mapper.toSaleDTO(repository.save(sale));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(SaleDTO entity) throws Exception {

        if(repository.findById(entity.getId_sale()).isPresent()){
            Sale sale = mapper.toSale(entity);
            repository.delete(sale);
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
    public void validate(SaleDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return repository.count();

    }

    @Override
    public List<SaleDTO> findByClientID(Integer id) {

        List<SaleDTO> lst = mapper.toSaleDTO(repository.findByClientID(id));

        return lst;

    }

    @Override
    public List<SaleDTO> findByPlanID(Integer id) {

        List<SaleDTO> lst = mapper.toSaleDTO(repository.findByPlanID(id));

        return lst;

    }

    @Override
    public SaleDTO findByClientIDAndPlanID(Integer clientId, Integer planId) {

        SaleDTO lst = mapper.toSaleDTO(repository.findByClientIDAndPlanID(clientId, planId));

        return lst;

    }

    @Override
    public void deleteByClientID(Integer id) {

        repository.deleteByClientID(id);

    }

    @Override
    public void deleteByPlanID(Integer id) {

        repository.deleteByPlanID(id);

    }

}