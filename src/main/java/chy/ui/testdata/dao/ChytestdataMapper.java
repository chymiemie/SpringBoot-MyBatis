package chy.ui.testdata.dao;

import chy.ui.testdata.model.Chytestdata;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ChytestdataMapper {
    @Delete({
        "delete from chytestdata",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into chytestdata (id, name, ",
        "sex, createtime)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(Chytestdata record);

    @InsertProvider(type=ChytestdataSqlProvider.class, method="insertSelective")
    int insertSelective(Chytestdata record);

    @Select({
        "select",
        "id, name, sex, createtime",
        "from chytestdata",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP)
    })
    Chytestdata selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ChytestdataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Chytestdata record);

    @Update({
        "update chytestdata",
        "set name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Chytestdata record);
    
    @Select("select * from chytestdata")
    List<Chytestdata> selectAll();
    
    @Update("update chytestdata set name = #{name,jdbcType=VARCHAR},sex = #{sex,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}")
    int updateTestdata(Chytestdata chytestdata);
    
    @Delete("delete from chytestdata where id = #{id,jdbcType=INTEGER}")
    int deleteByID(Integer id);
}