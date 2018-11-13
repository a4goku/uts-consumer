package uts.consumer.config.database;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uts.consumer.entity.BaseEntity;
import uts.consumer.utils.Pair;
import uts.consumer.utils.SelectorUtil;

@Aspect
@Component
public class SelectConnectionIntercepor implements Ordered {
    private static Logger logger = LoggerFactory.getLogger(SelectConnectionIntercepor.class);

    public static final String PREFIX = "uts";

    @Around("@annotation(selectConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, SelectConnection selectConnection) throws Throwable{
        try {
            logger.info("----------select database source----------");
            String currentDataBaseName = "";
            if (!StringUtils.isBlank(selectConnection.name())) {
                currentDataBaseName = selectConnection.name();
            } else {
                BaseEntity baseEntity = (BaseEntity) proceedingJoinPoint.getArgs()[0];
                String uuid = baseEntity.getId();
                Pair<Integer, Integer> pair = SelectorUtil.getDataBaseAndTableNumber(uuid);
                currentDataBaseName = PREFIX + pair.getObject1();

            }
            System.err.println("-------------------Intercepor, currentDataBaseName: " + currentDataBaseName);

            for (DataBaseContextHolder.DataBaseType type : DataBaseContextHolder.DataBaseType.values()) {
                if (!StringUtils.isBlank(currentDataBaseName)) {
                    String typeCode = type.getCode();
                    if (typeCode.equals(currentDataBaseName)) {
                        DataBaseContextHolder.setDataBaseType(type);
                        System.err.println("-------------------Intercepor, currentDataBase Code: "
                                + DataBaseContextHolder.getDataBaseType().getCode());
                    }
                }
            }
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DataBaseContextHolder.clearDataBaseType();
        }

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
