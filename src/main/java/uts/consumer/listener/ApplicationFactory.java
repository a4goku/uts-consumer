package uts.consumer.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFactory implements ApplicationContextAware {
    private static ApplicationContext ctx = null;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        if(ApplicationFactory.ctx == null) {
            ApplicationFactory.ctx = ctx;
        }
    }

    public static ApplicationContext getApplicationContext(){
        return ctx;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
