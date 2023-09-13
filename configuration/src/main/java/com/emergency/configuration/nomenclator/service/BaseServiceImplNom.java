package com.emergency.configuration.nomenclator.service;

import com.emergency.common.domain.entity.NomBase;
import com.emergency.common.domain.repository.NomBaseRepository;
import com.emergency.common.exception.DuplicateDataException;
import com.emergency.common.service.BaseService;
import com.emergency.common.config.ResponsePagination;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@AllArgsConstructor
public abstract class BaseServiceImplNom<C extends NomBase,  IDT> implements BaseService<C, IDT> {

    protected NomBaseRepository<C,IDT> nomBaseRepository;
    @Override
    public Long countData() {
        return nomBaseRepository.count();
    }

    @Override
    public ResponsePagination<C> findAll(Integer start, Integer limit) {
        try {
            List<C> data= nomBaseRepository.findAll(PageRequest.of(start, limit)).toList();
            Long countResgistry=this.countData();
            return new ResponsePagination<C>(data,countResgistry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findByName(String name, IDT id) {
        List<Optional<C>> optional=(id!=null) ? nomBaseRepository.findByNameIgnoreCaseAndIdIsNot(name,id) : nomBaseRepository.findByNameIgnoreCase(name);
        if (optional.size()>0) {
            throw new DuplicateDataException();
        }
    }

    @Override
    public C  findById(IDT id) {
        return nomBaseRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public C insertData(C obj) {
        findByName(obj.getName(), null);
       return nomBaseRepository.save(obj);
    }

    @Override
    public C updateData(C obj, IDT id) {
        nomBaseRepository.findById(id).orElseThrow(NoSuchElementException::new);
        this.findByName(obj.getName(),id);
        return nomBaseRepository.save(obj);
    }

    @Override
    public Boolean deleteData(IDT id) {
        C obj= nomBaseRepository.findById(id).orElseThrow(NoSuchElementException::new);
        nomBaseRepository.delete(obj);
        return true;
    }
}
