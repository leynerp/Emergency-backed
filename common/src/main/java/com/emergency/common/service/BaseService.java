package com.emergency.common.service;

import common.ResponsePagination;

public interface BaseService <C, IDT>{
    ResponsePagination<C> findAll(Integer start, Integer limit);
    Long countData();
    C  findById(IDT id);
    void  findByName(String name);
    C insertData(C objDto);
    C updateData(C objDto, IDT id);
    Boolean deleteData(IDT id);
}
