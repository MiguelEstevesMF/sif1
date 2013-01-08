package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.Transponder;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;


abstract class CronometragemAbstract implements Serializable{

    boolean activo ;

    TreeSet<CronometragemRegistro> registros ;

    TreeSet<Registro> registros_na ; /* nao activo */

    HashMap<Transponder,Registro> inicioSector = new HashMap<Transponder,Registro>();


    TreeSet<Loop> loops ;

    Loop finishLine ;

    Loop box ;


    int nRegistro;

    Date inicio ;


    Comparator descTimeCR ;

    Comparator descTimeR ;



    TreeSet<ScoreBoardRTRegistro> sb;


    public CronometragemAbstract(TreeSet<Loop> loops) {

        descTimeCR = new Comparator<CronometragemRegistro>(){
                                    public int compare(CronometragemRegistro cr0, CronometragemRegistro cr1) {
                                        return cr1.getTempoMedicao().compareTo(cr0.getTempoMedicao());
                                    }
                                } ;

        descTimeR = new Comparator<Registro>(){
                                public int compare(Registro r0, Registro r1) {
                                    return r1.getTempoTransponder().compareTo(r0.getTempoTransponder());
                                }
                               } ;


        activo = false ;

        registros = new TreeSet<CronometragemRegistro>( descTimeCR ) ;
       

        registros_na = new TreeSet<Registro>( descTimeR ) ;

        this.loops = loops  ;

        box = loops.pollFirst(); /* loop box -> pontoKM = -1  && esta a  entrada da Box */
        if(box.getPosicaoKm() != -1.0f){
            throw new RuntimeException("Erro ao estabelecer o loop Box\n");
        }

        finishLine = loops.pollFirst(); /* loop finishline -> pontoKm = 0 */
        if(finishLine.getPosicaoKm() != 0.0f){
            throw new RuntimeException("Erro ao estabelecer o loop FL\n");
        }

        nRegistro = 0 ;



    }

    public void start(){
        inicio = new Date();

        activo = true ;
    }

    public void stop(){
        activo = false ;
    }



    public abstract void processaRegistro(Registro r) ;

}

        