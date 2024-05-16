package co.edu.icesiviajes.service;

import co.edu.icesiviajes.domain.Sale;
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
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<SaleDTO> findAll() {

        List<SaleDTO> lstCliente = saleMapper.toSaleDTO(saleRepository.findAll());

        return lstCliente;
    }

    @Override
    public SaleDTO findById(Integer id) throws Exception {
        try{
            Sale sale = saleRepository.findById(id).get();
            return saleMapper.toSaleDTO(sale);
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public SaleDTO save(SaleDTO entity) throws Exception {

        Sale sale = saleMapper.toSale(entity);

        if(saleRepository.findById(sale.getId_sale()).isEmpty()){
            return saleMapper.toSaleDTO(saleRepository.save(sale));
        }else{
            throw new Exception("La entidad ya existe");
        }
    }

    @Override
    public SaleDTO update(SaleDTO entity) throws Exception {

        Sale sale = saleMapper.toSale(entity);

        if(saleRepository.findById(sale.getId_sale()).isPresent()){
            return saleMapper.toSaleDTO(saleRepository.save(sale));
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void delete(SaleDTO entity) throws Exception {

        Sale sale = saleMapper.toSale(entity);

        if(saleRepository.findById(sale.getId_sale()).isPresent()){
            saleRepository.delete(sale);
        }else{
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        try{
            Sale sale = saleRepository.findById(id).get();
            saleRepository.deleteById(sale.getId_sale());
        }catch (Exception e){
            throw new Exception("La entidad no existe");
        }
    }

    @Override
    public void validate(SaleDTO entity) throws Exception {

        //Vacio

    }

    @Override
    public Long count() {

        return saleRepository.count();

    }

}
