package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.Transponder;
import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class CronometragemQualificacao extends CronometragemAbstract implements Serializable {


    private HashMap<Transponder,TreeMap<Integer,TreeMap<Integer,CronometragemRegistro>>> trp_vlt_sect_rgt ;

    private HashMap<Transponder,TreeMap<Integer,HashSet<Integer>>> trp_qlf_vlt ;

    private HashMap<Transponder,Boolean> emVolta ;

    private TreeSet<Registro> registros_fv ;

    private int currentQ;




    public CronometragemQualificacao(TreeSet<Loop> loops) {
        super(loops);
        registros_fv = new TreeSet<Registro>( descTimeR ) ;
        emVolta = new HashMap<Transponder, Boolean>();
        trp_vlt_sect_rgt = new HashMap<Transponder, TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>>();
        trp_qlf_vlt = new HashMap<Transponder, TreeMap<Integer, HashSet<Integer>>>();
        currentQ = 1;

        Comparator<ScoreBoardRTRegistro> sbc = new Comparator<ScoreBoardRTRegistro>() {

            public int compare(ScoreBoardRTRegistro sbr1, ScoreBoardRTRegistro sbr2) {

                Entry<Integer,Long> mtuq1 = sbr1.getTempo_melhor_Volta().lastEntry();
                Entry<Integer,Long> mtuq2 = sbr2.getTempo_melhor_Volta().lastEntry();

                if(mtuq1==null){
                    mtuq1 = new SimpleEntry<Integer, Long>(0,Long.MAX_VALUE);
                }
                if(mtuq2==null){
                    mtuq2 = new SimpleEntry<Integer, Long>(0,Long.MAX_VALUE);
                }

                int difQ = mtuq2.getKey()-mtuq1.getKey();

                if(difQ!=0){
                    return difQ;
                }
                else{
                    int difT = (int)(mtuq1.getValue()-mtuq2.getValue());
                    if(difT!=0){
                        return difT;
                    }
                    else{
                        return sbr1.getNomePiloto().compareTo(sbr2.getNomePiloto());
                    }

                }
            }
        };

        sb = new TreeSet<ScoreBoardRTRegistro>(sbc);


    }



    public void processaRegistro(Registro r){

        if(activo){
            Transponder rt = r.getTransponder();
            Loop rl = r.getLoop();
            if(emVolta.containsKey(rt)){

                Entry<Integer,TreeMap<Integer, CronometragemRegistro>> voltaEntry = trp_vlt_sect_rgt.get(rt).lastEntry();

                if(emVolta.get(rt)){

                    Piloto rp = rt.getPiloto();
                    ////////////////////////
                    ScoreBoardRTRegistro sbr = null;
                    boolean found = false;
                    Iterator<ScoreBoardRTRegistro> it = sb.iterator();

                    while(!found && it.hasNext()){
                        sbr = it.next();
                        if(sbr.getPiloto().getID() == rp.getID()){
                            found = true;
                        }
                    }

                    if(!found){
                        sbr = new ScoreBoardRTRegistro(rp,false);
                        //sb.add(sbr);
                    }
                    sb.remove(sbr);
                    //////////////

                    if(rl.equals(box)){
                        emVolta.put(rt,Boolean.FALSE);
                        voltaEntry.getValue().clear();
                        sbr.getTempos_sectors_ultimo().clear();
                    }
                    else{

                        int nReg = nRegistro++;
                        int nPiloto = rp.getNumero();
                        Equipa re = rp.getEquipa_actual();
                        String nmEquipa = re.getNome();
                        String nmPiloto = rp.getNome();
                        String transponderRef = rt.getRef();
                        Entry<Integer,CronometragemRegistro> sectorEntry = voltaEntry.getValue().lastEntry();
                        int sector = sectorEntry == null?1:sectorEntry.getKey()+1;
                        String loopRef = rl.getRef();
                        long tempo = r.getTempoTransponder().getTime() - inicioSector.get(rt).getTempoTransponder().getTime() ;
                        long tempoProva = r.getTempoTransponder().getTime() - inicio.getTime() ;
                        Date tempoMedicao = r.getTempoTransponder();


                        int potenciaSinal = r.getPotenciaSinal();
                        int hits = r.getHits();


                        int volta = voltaEntry.getKey();
                        boolean pit = false;

                        CronometragemRegistro cr = new CronometragemRegistro(nReg, nPiloto, nmEquipa, nmPiloto, transponderRef, sector, loopRef, tempo, tempoProva, tempoMedicao, potenciaSinal, hits, volta, pit);
                        registros.add(cr);

                        voltaEntry.getValue().put(sector,cr);

                        /// /// ///


                        sbr.getTempos_sectors_ultimo().put(sector, tempo);
                        TreeMap<Integer,Long> _time = sbr.getTempos_sectors_melhor();
                        if(_time.containsKey(sector)){
                            if(_time.get(sector).compareTo(tempo)>0){
                                _time.put(sector,tempo);
                            }
                        }
                        else{
                            _time.put(sector,tempo);
                        }

                        sbr.setSector(sector);

                        /// /// ///


                        if(rl.equals(finishLine)){
                            TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer, CronometragemRegistro>();
                            trp_vlt_sect_rgt.get(rt).put(volta+1,sectores);

                            trp_qlf_vlt.get(rt).get(currentQ).add(volta);

                            /// /// ///

                            sbr.setVolta(volta+1);

                            long tempoVolta = 0;

                            for(long tempoSector : sbr.getTempos_sectors_ultimo().values()){
                                tempoVolta += tempoSector;
                            }

                            sbr.setTempo_ultima_volta(tempoVolta);

                            _time = sbr.getTempo_melhor_Volta();

                            if(_time.containsKey(currentQ)){
                                if(_time.get(currentQ).compareTo(tempoVolta)>0){
                                    _time.put(currentQ,tempoVolta);
                                }
                            }
                            else{
                                _time.put(currentQ,tempoVolta);
                            }

                        }
                    }
                    sb.add(sbr);
                    refresh();
                    /////////////
                }
                else{
                    registros_fv.add(r);
                    emVolta.put(rt,rl.equals(finishLine));
                }
            }
            else{
                emVolta.put(rt,rl.equals(finishLine));
                TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>> voltas = new TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>();
                TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer, CronometragemRegistro>();
                voltas.put(1,sectores);
                trp_vlt_sect_rgt.put(rt,voltas);
                registros_fv.add(r);

                TreeMap<Integer,HashSet<Integer>> qualificativas = new TreeMap<Integer, HashSet<Integer>>();
                HashSet<Integer> voltasQ = new HashSet<Integer>();
                qualificativas.put(currentQ,voltasQ);
                trp_qlf_vlt.put(rt,qualificativas);
            }
            inicioSector.put(rt,r);
        }
        else{
            registros_na.add(r);
        }
    }


    public int getCurrentQ(){
        return currentQ;
    }


    public void nextQ(){
        currentQ++;
        for( TreeMap<Integer,HashSet<Integer>> q : trp_qlf_vlt.values()){
            HashSet<Integer> voltasQ = new HashSet<Integer>();
            q.put(currentQ,voltasQ);
        }
    }


        private void refresh(){


        ScoreBoardRTRegistro sbr = sb.first();

        sbr.setPosicao(1);
        sbr.setDiff_u_primeiro(0);
        sbr.setDiff_u_frente(0);
        sbr.setDiff_gap_primeiro(0);
        sbr.setDiff_gap_frente(0);

        int posicao_a = 1;
        int count = 1;

        long time_u_primeiro = sbr.getTempo_ultima_volta();
        long time_u_anterior = time_u_primeiro;

        Entry<Integer,Long> e = sbr.getTempo_melhor_Volta().lastEntry();

        long time_gap_primeiro;
        int q_p;
        int q_f;

        if(e==null){
            time_gap_primeiro = Long.MAX_VALUE;
            q_p = 1 ;
            q_f = 1 ;
        }
        else{
            time_gap_primeiro = e.getValue();
            q_p = e.getKey();
            q_f = q_p ;
        }

        long time_gap_anterior = time_gap_primeiro;


        for(ScoreBoardRTRegistro sbr_ : sb){
            long diff_u_p = sbr_.getTempo_ultima_volta() - time_u_primeiro ;
            long diff_u_f = sbr_.getTempo_ultima_volta() - time_u_anterior ;

            e = sbr_.getTempo_melhor_Volta().lastEntry();

            if(e==null){
                sbr_.setPosicao(posicao_a);
            }
            else{
                long diff_gap_p = 0;
                long diff_gap_f = 0;
                boolean gap_f = true;
                if(e.getKey() == q_p){
                    diff_gap_p = e.getValue()==null?0:e.getValue()-time_gap_primeiro;
                }
                if(e.getKey() == q_f){
                    diff_gap_f = e.getValue()==null?0:e.getValue()-time_gap_anterior;
                    gap_f = diff_gap_f != 0;
                }

                q_f = e.getKey();

                if(gap_f){
                    sbr_.setPosicao(count);
                    posicao_a = count;
                }
                else{
                    sbr_.setPosicao(posicao_a);
                }

                sbr_.setDiff_u_primeiro(diff_u_p);
                sbr_.setDiff_u_frente(diff_u_f);
                sbr_.setDiff_gap_primeiro(diff_gap_p);
                sbr_.setDiff_gap_frente(diff_gap_f);

                time_u_anterior = sbr_.getTempo_ultima_volta() ;
                time_gap_anterior = e.getValue() == null?Long.MAX_VALUE:e.getValue();

            }
        count++;
        }

    }





}