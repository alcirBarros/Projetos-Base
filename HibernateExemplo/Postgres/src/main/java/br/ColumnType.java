package br;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;

@Entity
@Table(name = "clm_column", catalog = "hibernateDB")
public class ColumnType implements Serializable {

    private static final long serialVersionUID = -1126242111171968609L;

    @Id
    @GeneratedValue
    @Column(name = "clm_id", nullable = false)
    private Integer id;

    @Column(name = "clm_column_string")
    private String columnString;

    @Column(name = "clm_column_integer")
    private Integer columnInteger;

    @Column(name = "clm_column_long")
    private Long columnLong;

    @Column(name = "clm_column_boolean")
    private Boolean columnBoolean;

    @Column(name = "clm_column_dataTime")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date columnDataTime;

    @Column(name = "clm_column_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date columnDate;

    @Column(name = "clm_column_time")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date columnTime;

    @Column(name = "clm_column_bigInteger")
    private BigInteger columnBigInteger;

    @Column(name = "clm_column_bigDecimal")
    private BigDecimal columnBigDecimal;

    @Version
    @Column(name = "clm_column_version")
    private Long version;

//    @Version
//    @Column(name = "clm_column_version_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date versionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnString() {
        return columnString;
    }

    public void setColumnString(String columnString) {
        this.columnString = columnString;
    }

    public Integer getColumnInteger() {
        return columnInteger;
    }

    public void setColumnInteger(Integer columnInteger) {
        this.columnInteger = columnInteger;
    }

    public Long getColumnLong() {
        return columnLong;
    }

    public void setColumnLong(Long columnLong) {
        this.columnLong = columnLong;
    }

    public Boolean getColumnBoolean() {
        return columnBoolean;
    }

    public void setColumnBoolean(Boolean columnBoolean) {
        this.columnBoolean = columnBoolean;
    }

    public Date getColumnDataTime() {
        return columnDataTime;
    }

    public void setColumnDataTime(Date columnDataTime) {
        this.columnDataTime = columnDataTime;
    }

    public Date getColumnDate() {
        return columnDate;
    }

    public void setColumnDate(Date columnDate) {
        this.columnDate = columnDate;
    }

    public Date getColumnTime() {
        return columnTime;
    }

    public void setColumnTime(Date columnTime) {
        this.columnTime = columnTime;
    }

    public BigInteger getColumnBigInteger() {
        return columnBigInteger;
    }

    public void setColumnBigInteger(BigInteger columnBigInteger) {
        this.columnBigInteger = columnBigInteger;
    }

    public BigDecimal getColumnBigDecimal() {
        return columnBigDecimal;
    }

    public void setColumnBigDecimal(BigDecimal columnBigDecimal) {
        this.columnBigDecimal = columnBigDecimal;
    }

}
