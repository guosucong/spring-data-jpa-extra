package com.slyak.spring.jpa.auditing;

import com.slyak.spring.jpa.repository.GenericJpaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * .
 *
 * @author stormning on 16/6/19.
 */
@NoRepositoryBean
public interface CachingJpaRepository<T, ID extends Serializable> extends GenericJpaRepository<T, ID> {

    @Cacheable(value = "dict")
    @Override
    T findOne(ID id);

    @Cacheable(value = "dict")
    @Override
    List<T> findAll();

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    <S extends T> S save(S toSave);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void deleteInBatch(Iterable<T> entities);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    <S extends T> S saveAndFlush(S entity);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void deleteAllInBatch();

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void delete(ID id);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void delete(T entity);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void delete(Iterable<? extends T> entities);

    @CacheEvict(value = "dict", allEntries = true)
    @Override
    void deleteAll();
}
