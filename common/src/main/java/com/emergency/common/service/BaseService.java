package com.emergency.common.service;

import com.emergency.common.config.ResponsePagination;

public interface BaseService <C, IDT>{
    ResponsePagination<C> findAll(Integer start, Integer limit);
    Long countData();
    C  findById(IDT id);
    void  findByName(String name, IDT id);
    C insertData(C objDto);
    C updateData(C objDto, IDT id);
    Boolean deleteData(IDT id);
}
