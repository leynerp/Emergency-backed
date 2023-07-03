package com.emergency.configuration.person.service;

import com.emergency.common.domain.repository.PersonBaseRepository;
import com.emergency.common.service.BaseService;
import com.emergency.common.config.ResponsePagination;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonBaseServiceImpl<C,  IDT> implements BaseService<C, IDT> {

    protected PersonBaseRepository<C,IDT> baseRepository;
    @Override
    public Long countData() {
        return baseRepository.count();
    }

    @Override
    public ResponsePagination<C> findAll(Integer start, Integer limit) {
        try {
            List<C> data= baseRepository.findAll(PageRequest.of(start, limit)).toList();
            Long countResgistry=this.countData();
            return new ResponsePagination<C>(data,countResgistry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public C  findById(IDT id) {
        return baseRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void findByName(String name) {

    }

    @Override
    public C insertData(C obj) {

        return baseRepository.save(obj);
    }

    @Override
    public C updateData(C obj, IDT id) {
        baseRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return baseRepository.save(obj);
    }

    @Override
    public Boolean deleteData(IDT id) {
        C obj= baseRepository.findById(id).orElseThrow(NoSuchElementException::new);
        baseRepository.delete(obj);
        return true;
    }
}
