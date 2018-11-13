package uts.consumer.utils;


import uts.consumer.entity.TradeDetail;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class GeneratorDataUtil {
    private static Random random = new Random();

    private static Date getRandomDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = new Date(117,
                random.nextInt(7),
                (int)(Math.random()*28)+1,
                (int)(Math.random()*23)+1,
                (int)(Math.random()*59)+1,
                (int)(Math.random()*59)+1);
        System.out.println(formatter.format(d));
        return d;
    }

    static Object[] accouts = null;
    static {
        Pair p1 = new Pair<String, String>("张三", "30001040191113380583");
        Pair p2 = new Pair<String, String>("李四", "40032440191113380274");
        Pair p3 = new Pair<String, String>("王五", "50033040191113380965");
        Pair p4 = new Pair<String, String>("赵六", "68801040191113380926");
        accouts = new Object[]{p1, p2, p3, p4};
    }

    static Object[] oppAccounts = null;
    static {
        Pair p1 = new Pair<String, String>("小1","155001040191113380583");
        Pair p2 = new Pair<String, String>("小2","236010401914113389642");
        Pair p3 = new Pair<String, String>("小3","396810401912113383825");
        Pair p4 = new Pair<String, String>("小4","485110401911133806872");
        Pair p5 = new Pair<String, String>("小5","589125040191311384628");
        oppAccounts = new Object[]{p1, p2, p3, p4};
    }

    private static String generateSerialno(Date d){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        StringBuffer key = new StringBuffer();
        key.append(formatter.format(d));
        String uid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        key.append(uid.substring(12));
        return key.toString();
    }

    private static Pair getRandomAccounts(){
        return (Pair) accouts[random.nextInt(accouts.length)];
    }

    private static Pair getRandomOppAccounts(){
        return (Pair) oppAccounts[random.nextInt(oppAccounts.length)];
    }

    static Object[] digests = null;
    static{
        String d1 = "转账";
        String d2 = "付款";
        String d3 = "百度买单";
        String d4 = "美团买单";
        String d5 = "淘宝买单";

        digests = new Object[]{d1, d2, d3, d4, d5};
    }

    private static String getRandomDigest(){
        return (String) digests[random.nextInt(digests.length)];
    }

    public static void main(String[] args) {
        System.err.println(getRandomBalance());
    }

    private static int getRandomCreditAmount(){
        return (int) ((Math.random()*100) + (Math.random()*300) + (Math.random()*80));
    }

    private static int getRandomBalance(){
        return (int) ((Math.random()*100000) + (Math.random()*3000) + (Math.random()*500));
    }

    public static TradeDetail generator(){
        TradeDetail td1 = new TradeDetail();
        td1.setId(KeyUtil.generatorUUID());
        Date tradeDate = getRandomDate();

        td1.setSerialno(generateSerialno(tradeDate));
        td1.setTradedate(tradeDate);
        td1.setCreditamount(new BigDecimal(getRandomCreditAmount()));
        td1.setDedbitamount(new BigDecimal(0));
        td1.setBusinesstype("1");
        td1.setBalance(new BigDecimal(getRandomBalance()));

        Pair account = getRandomAccounts();
        td1.setAccountname((String) account.getObject1());
        td1.setAccountno((String) account.getObject2());

        Pair oppAccount = getRandomOppAccounts();
        td1.setOppaccountname((String) oppAccount.getObject1());
        td1.setOppaccountno((String) oppAccount.getObject2());

        td1.setDigest(getRandomDigest());
        td1.setStatus("0");
        td1.setCreateby("system");
        td1.setCreatetime(new Date());
        td1.setUpdateby("system");
        td1.setUpdatetime(new Date());
        return td1;
    }
}
