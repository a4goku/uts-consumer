package uts.consumer.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TradeDetail extends BaseEntity{
    private String id;

    /**
     * 交易流水号
     */
    private String serialno;

    /**
     * 交易时间
     */
    private Date tradedate;

    /**
     * 借方金额
     */
    private BigDecimal dedbitamount;

    /**
     * 贷方金额
     */
    private BigDecimal creditamount;

    /**
     * 交易类型
     */
    private String businesstype;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 对方账户名
     */
    private String oppaccountname;

    /**
     * 对方账号
     */
    private String oppaccountno;

    /**
     * 本方账户名
     */
    private String accountname;

    /**
     * 本方账号
     */
    private String accountno;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 同步标记
     */
    private String status;

    /**
     * 创建人
     */
    private String createby;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新人
     */
    private String updateby;

    /**
     * 更新时间
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    public BigDecimal getDedbitamount() {
        return dedbitamount;
    }

    public void setDedbitamount(BigDecimal dedbitamount) {
        this.dedbitamount = dedbitamount;
    }

    public BigDecimal getCreditamount() {
        return creditamount;
    }

    public void setCreditamount(BigDecimal creditamount) {
        this.creditamount = creditamount;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getOppaccountname() {
        return oppaccountname;
    }

    public void setOppaccountname(String oppaccountname) {
        this.oppaccountname = oppaccountname;
    }

    public String getOppaccountno() {
        return oppaccountno;
    }

    public void setOppaccountno(String oppaccountno) {
        this.oppaccountno = oppaccountno;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TradeDetail other = (TradeDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()))
                && (this.getTradedate() == null ? other.getTradedate() == null : this.getTradedate().equals(other.getTradedate()))
                && (this.getDedbitamount() == null ? other.getDedbitamount() == null : this.getDedbitamount().equals(other.getDedbitamount()))
                && (this.getCreditamount() == null ? other.getCreditamount() == null : this.getCreditamount().equals(other.getCreditamount()))
                && (this.getBusinesstype() == null ? other.getBusinesstype() == null : this.getBusinesstype().equals(other.getBusinesstype()))
                && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
                && (this.getOppaccountname() == null ? other.getOppaccountname() == null : this.getOppaccountname().equals(other.getOppaccountname()))
                && (this.getOppaccountno() == null ? other.getOppaccountno() == null : this.getOppaccountno().equals(other.getOppaccountno()))
                && (this.getAccountname() == null ? other.getAccountname() == null : this.getAccountname().equals(other.getAccountname()))
                && (this.getAccountno() == null ? other.getAccountno() == null : this.getAccountno().equals(other.getAccountno()))
                && (this.getDigest() == null ? other.getDigest() == null : this.getDigest().equals(other.getDigest()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateby() == null ? other.getCreateby() == null : this.getCreateby().equals(other.getCreateby()))
                && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
                && (this.getUpdateby() == null ? other.getUpdateby() == null : this.getUpdateby().equals(other.getUpdateby()))
                && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        result = prime * result + ((getTradedate() == null) ? 0 : getTradedate().hashCode());
        result = prime * result + ((getDedbitamount() == null) ? 0 : getDedbitamount().hashCode());
        result = prime * result + ((getCreditamount() == null) ? 0 : getCreditamount().hashCode());
        result = prime * result + ((getBusinesstype() == null) ? 0 : getBusinesstype().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getOppaccountname() == null) ? 0 : getOppaccountname().hashCode());
        result = prime * result + ((getOppaccountno() == null) ? 0 : getOppaccountno().hashCode());
        result = prime * result + ((getAccountname() == null) ? 0 : getAccountname().hashCode());
        result = prime * result + ((getAccountno() == null) ? 0 : getAccountno().hashCode());
        result = prime * result + ((getDigest() == null) ? 0 : getDigest().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateby() == null) ? 0 : getCreateby().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdateby() == null) ? 0 : getUpdateby().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialno=").append(serialno);
        sb.append(", tradedate=").append(tradedate);
        sb.append(", dedbitamount=").append(dedbitamount);
        sb.append(", creditamount=").append(creditamount);
        sb.append(", businesstype=").append(businesstype);
        sb.append(", balance=").append(balance);
        sb.append(", oppaccountname=").append(oppaccountname);
        sb.append(", oppaccountno=").append(oppaccountno);
        sb.append(", accountname=").append(accountname);
        sb.append(", accountno=").append(accountno);
        sb.append(", digest=").append(digest);
        sb.append(", status=").append(status);
        sb.append(", createby=").append(createby);
        sb.append(", createtime=").append(createtime);
        sb.append(", updateby=").append(updateby);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}
