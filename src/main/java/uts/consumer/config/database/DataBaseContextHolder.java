package uts.consumer.config.database;

public class DataBaseContextHolder {
    public enum DataBaseType{
        UTS1("uts1"),
        UTS2("uts2"),
        UTS3("uts3"),
        UTS4("uts4");

        private String code;

        private DataBaseType(String code){
            this.code = code;
        }

        public String getCode(){
            return this.code;
        }
    }

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();

    public static void setDataBaseType(DataBaseType dataBaseType){
        if(dataBaseType == null){
            throw new NullPointerException(".......");
        }
        contextHolder.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType(){
        return contextHolder.get() == null ? DataBaseType.UTS1 : contextHolder.get();
    }

    public static void clearDataBaseType(){
        contextHolder.remove();
    }
}
