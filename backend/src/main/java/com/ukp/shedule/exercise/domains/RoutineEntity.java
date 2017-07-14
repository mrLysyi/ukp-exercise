package com.ukp.shedule.exercise.domains;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "[routine]", schema = "dbo")
public class RoutineEntity {
    private int idOrigin;
    private int id;
    private Timestamp workfrom;
    private Timestamp workto;
    private Timestamp intervalfrom;
    private Timestamp intervalto;
    private PnDaynamesEntity pnDaynamesByDayofweek;

    @Id
    @Column(name = "id_origin", nullable = false)
    public int getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(int idOrigin) {
        this.idOrigin = idOrigin;
    }

    @Basic
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "workfrom", nullable = true)
    public Timestamp getWorkfrom() {
        return workfrom;
    }

    public void setWorkfrom(Timestamp workfrom) {
        this.workfrom = workfrom;
    }

    @Basic
    @Column(name = "workto", nullable = true)
    public Timestamp getWorkto() {
        return workto;
    }

    public void setWorkto(Timestamp workto) {
        this.workto = workto;
    }

    @Basic
    @Column(name = "intervalfrom", nullable = true)
    public Timestamp getIntervalfrom() {
        return intervalfrom;
    }

    public void setIntervalfrom(Timestamp intervalfrom) {
        this.intervalfrom = intervalfrom;
    }

    @Basic
    @Column(name = "intervalto", nullable = true)
    public Timestamp getIntervalto() {
        return intervalto;
    }

    public void setIntervalto(Timestamp intervalto) {
        this.intervalto = intervalto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutineEntity that = (RoutineEntity) o;

        if (idOrigin != that.idOrigin) return false;
        if (id != that.id) return false;
        if (workfrom != null ? !workfrom.equals(that.workfrom) : that.workfrom != null) return false;
        if (workto != null ? !workto.equals(that.workto) : that.workto != null) return false;
        if (intervalfrom != null ? !intervalfrom.equals(that.intervalfrom) : that.intervalfrom != null) return false;
        if (intervalto != null ? !intervalto.equals(that.intervalto) : that.intervalto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrigin;
        result = 31 * result + id;
        result = 31 * result + (workfrom != null ? workfrom.hashCode() : 0);
        result = 31 * result + (workto != null ? workto.hashCode() : 0);
        result = 31 * result + (intervalfrom != null ? intervalfrom.hashCode() : 0);
        result = 31 * result + (intervalto != null ? intervalto.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "dayofweek", referencedColumnName = "id")
    public PnDaynamesEntity getPnDaynamesByDayofweek() {
        return pnDaynamesByDayofweek;
    }

    public void setPnDaynamesByDayofweek(PnDaynamesEntity pnDaynamesByDayofweek) {
        this.pnDaynamesByDayofweek = pnDaynamesByDayofweek;
    }
}
