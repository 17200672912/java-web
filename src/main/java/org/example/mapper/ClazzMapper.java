package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Clazz;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(String name, LocalDate begin, LocalDate end);
@Delete("delete from clazz where id=#{id}")
    void deleteById(Integer id);
    @Insert("insert into clazz VALUES (null,#{name},#{room},#{beginDate},#{endDate},#{masterId}, #{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);
    @Select("select * from clazz where  id = #{id}")
    Clazz getById(Integer id);

    void update(Clazz clazz);
    @Select("select * from clazz")
    List<Clazz> findAll();
}
