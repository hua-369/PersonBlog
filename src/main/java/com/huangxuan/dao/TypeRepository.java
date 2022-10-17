package com.huangxuan.dao;
import com.huangxuan.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
    @Query("select distinct t from Type t join Blog b on b.type.id=t.id where b.issue=true ")
    List<Type> findTop(Pageable pageable);
}
