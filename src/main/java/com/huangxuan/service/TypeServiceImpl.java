package com.huangxuan.service;

import com.huangxuan.NotFoundExceptionn;
import com.huangxuan.dao.TypeRepository;
import com.huangxuan.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getType(Long id) {

        return typeRepository.getById(id);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {

        return typeRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Type type1=typeRepository.getById(id);
        if (type1==null){
            throw new NotFoundExceptionn("不存在该类型");
        }
        BeanUtils.copyProperties(type,type1);
        return typeRepository.save(type1);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort by = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable= PageRequest.of(0,size,by);
        return typeRepository.findTop(pageable);
    }
}
