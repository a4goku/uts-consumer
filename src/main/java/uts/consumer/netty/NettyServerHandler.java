package uts.consumer.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uts.consumer.config.database.DruidDataSourceConfig;
import uts.consumer.entity.TradeDetail;
import uts.consumer.listener.ApplicationFactory;
import uts.consumer.service.TradeDetailService;
import uts.consumer.utils.Const;
import uts.consumer.utils.FastJsonConvertUtil;
import uts.sender.protocol.Req;
import uts.sender.protocol.Resp;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        Req req = (Req)msg;

        String id = req.getId();
        String tag = req.getTag();
        String type = req.getType();
        String requestMessage = req.getRequestMessage();

        logger.info("id:{}, tag:{}, type:{}, requestMessage:{}", id, tag, type, requestMessage);

        Resp resp = new Resp();
        try {
            if(Const.TRADE_DETAIL.equals(tag)) {
                TradeDetailService tradeDetailService = (TradeDetailService)ApplicationFactory.getBean("tradeDetailService");
                TradeDetail td = FastJsonConvertUtil.convertJSONToObject(requestMessage, TradeDetail.class);

                if(Const.SAVE.equals(type)){
                    int ret = tradeDetailService.balanceInsert(td);

                    if(ret == 1){
                        resp.setId(id);
                        resp.setTag(tag);
                        resp.setType(Const.UPDATE);
                        resp.setResponseCode(Const.RESPONSE_CODE_OK);
                        ctx.writeAndFlush(resp);
                    } else if(ret == 0) {
                        resp.setId(id);
                        resp.setTag(tag);
                        resp.setType(Const.UPDATE);
                        resp.setResponseCode(Const.RESPONSE_CODE_INSERT_ERR);
                        ctx.writeAndFlush(resp);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setId(id);
            resp.setTag(tag);
            resp.setType(Const.UPDATE);
            resp.setResponseCode(Const.RESPONSE_CODE_SERVER_ERR);
            resp.setResponseMessage(e.getMessage());
            ctx.writeAndFlush(resp);
        }

    }
}
