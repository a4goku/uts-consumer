package uts.consumer.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uts.consumer.config.database.SelectConnection;
import uts.consumer.entity.TradeDetail;
import uts.consumer.mapper.TradeDetailMapper;
import uts.consumer.utils.FastJsonConvertUtil;
import uts.consumer.utils.Pair;
import uts.consumer.utils.SelectorUtil;

import java.util.Map;

@Service
public class TradeDetailService {
    private static final String TABLE_NAME_PREFIX = "TRADE_DETAIL_";

    @Autowired
    private TradeDetailMapper tradeDetailMapper;

    @SelectConnection
    public int balanceInsert(TradeDetail td){
        String uuid = td.getId();
        Pair<Integer, Integer> pair = SelectorUtil.getDataBaseAndTableNumber(uuid);
        Integer tableNumber = pair.getObject2();
        String tableName = TABLE_NAME_PREFIX + tableNumber;
        JSONObject json = FastJsonConvertUtil.convertObjectToJSONObject(td);
        Map<String, Object> params = FastJsonConvertUtil.convertJSONToObject(json, Map.class);
        params.put("tableName", tableName);
        return tradeDetailMapper.balanceInsert(params);
    }

    public TradeDetail balanceSelectByPrimaryKey(String uuid){
        Pair<Integer, Integer> pair = SelectorUtil.getDataBaseAndTableNumber(uuid);
        Integer tableNumber = pair.getObject2();
        String tableName = TABLE_NAME_PREFIX + tableNumber;
        return tradeDetailMapper.balanceSelectByPrimaryKey(tableName, uuid);

    }
}
