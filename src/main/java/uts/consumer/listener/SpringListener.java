package uts.consumer.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import uts.consumer.netty.NettyServer;

@Component("springListener")
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法
            System.out.println("spring 加载完成。。。");
            try {
                NettyServer.getInstance().start();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
