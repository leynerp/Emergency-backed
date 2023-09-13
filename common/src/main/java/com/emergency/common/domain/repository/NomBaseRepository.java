package com.emergency.common.domain.repository;

import com.emergency.common.domain.entity.NomBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface NomBaseRepository<C extends NomBase,I> extends JpaRepository<C,I> {
   List<Optional<C>> findByNameIgnoreCaseAndIdIsNot(String name,I id);
   List<Optional<C>> findByNameIgnoreCase(String name);
}
