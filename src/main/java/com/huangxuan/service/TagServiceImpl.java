package com.huangxuan.service;

import com.huangxuan.NotFoundExceptionn;
import com.huangxuan.dao.TagRepository;
import com.huangxuan.po.Blog;
import com.huangxuan.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTag(Long id) {

        return tagRepository.getById(id);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {

        return tagRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag tag1=tagRepository.getById(id);
        if (tag1==null){
            throw new NotFoundExceptionn("不存在该类型");
        }
        BeanUtils.copyProperties(tag,tag1);
        return tagRepository.save(tag1);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(convertToList(ids));
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort by = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable= PageRequest.of(0,size,by);
        return tagRepository.findTop(pageable);
    }
}
