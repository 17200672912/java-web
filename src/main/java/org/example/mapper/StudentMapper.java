package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(String name, Integer degree, Integer clazzId);
@Select("select count(*) from student s where s.clazz_id=#{id}")
    int countByClazzId(Integer id);

    void delete(List<Integer> ids);
    @Insert("insert into student(name, no, gender, phone,id_card, is_college, address, degree, graduation_date,clazz_id, create_time, update_time) VALUES " +
            "(#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId},#{createTime},#{updateTime})")
    void insert(Student student);
    @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    void update(Student student);
    @Update("update student set violation_count = violation_count + 1 , violation_score = violation_score + #{score} , update_time = now() where id = #{id}")
    void violationHandle(Integer id, Integer score);
@MapKey("name")
    List<Map<String, Object>> getStudentDegreeData();
    @Select("select c.name cname , count(s.id) scount from clazz c  left join student s on s.clazz_id = c.id group by c.name order by count(s.id) desc ")
    List<Map<String, Object>> getStudentCountData();
}
