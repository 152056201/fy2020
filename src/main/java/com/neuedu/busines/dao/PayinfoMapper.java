package com.neuedu.busines.dao;

import com.neuedu.busines.pojo.Payinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payinfo record);

    int insertSelective(Payinfo record);

    Payinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Payinfo record);

    int updateByPrimaryKey(Payinfo record);
}
