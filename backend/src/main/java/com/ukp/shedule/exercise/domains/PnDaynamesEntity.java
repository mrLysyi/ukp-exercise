package com.ukp.shedule.exercise.domains;

import javax.persistence.*;


@Entity
@Table(name = "pn_daynames", schema = "dbo", catalog = "")
public class PnDaynamesEntity {
    private short id;
    private String name;
    private Integer countday;
    private Integer orderby;
    private String shortName;
    private String days;

    @Id
    @Column(name = "id", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "countday", nullable = true)
    public Integer getCountday() {
        return countday;
    }

    public void setCountday(Integer countday) {
        this.countday = countday;
    }

    @Basic
    @Column(name = "orderby", nullable = true)
    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    @Basic
    @Column(name = "short_name", nullable = true, length = 10)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "days", nullable = true, length = 50)
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PnDaynamesEntity that = (PnDaynamesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (countday != null ? !countday.equals(that.countday) : that.countday != null) return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (countday != null ? countday.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        return result;
    }
}
