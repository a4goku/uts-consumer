package uts.consumer.mapper;


import org.apache.ibatis.annotations.Param;
import uts.consumer.config.database.BaseMapper;
import uts.consumer.entity.TradeDetail;

import java.util.Map;

public interface TradeDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(TradeDetail record);

    int insertSelective(TradeDetail record);

    TradeDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TradeDetail record);

    int updateByPrimaryKey(TradeDetail record);

    int balanceInsert(Map<String, Object> params);

    TradeDetail balanceSelectByPrimaryKey(@Param("tableName") String tableName, @Param("id")String uuid);
}
