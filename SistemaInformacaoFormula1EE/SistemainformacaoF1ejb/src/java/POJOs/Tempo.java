
package POJOs;

import java.sql.Time;


public class Tempo extends Time {

    private static long dif = 3600000;

    public Tempo() {
        super(-dif);
    }

    public Tempo(long l) {
        super(l-dif);
    }

    public long getTime() {
        return super.getTime()+dif;
    }

    public String toString() {
        if(getTime()==0) return "";
        return super.toString()+","+String.format("%03d",getTime()-(getTime()/1000*1000)) ;
    }

    public String toStringQ() {
        if(getTime()==0) return "";
        return String.format("%02d:%02d,%03d",super.getMinutes(),super.getSeconds(),getTime()-(getTime()/1000*1000)) ;
    }

}