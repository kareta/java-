package kareta.laboratoryworks.lab5;

import java.util.Date;

public class Period implements Comparable<Period> {
    private Date begin;
    private Date end;

    public Period(Date begin, Date end) {
        this.begin = begin;
        this.end = end;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public int compareTo(Period period) {
        if (getBegin().getTime() > period.getBegin().getTime()) {
            return 1;
        } else if (getBegin().getTime() < period.getBegin().getTime()) {
            return -1;
        }
        return 0;
    }
}
