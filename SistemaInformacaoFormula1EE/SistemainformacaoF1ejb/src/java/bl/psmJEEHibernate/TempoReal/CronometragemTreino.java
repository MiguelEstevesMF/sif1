package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.Transponder;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


class CronometragemTreino extends CronometragemAbstract implements Serializable {


    private HashMap<Transponder,TreeMap<Integer,TreeMap<Integer,CronometragemRegistro>>> trp_vlt_sect_rgt ;

    private HashMap<Transponder,Boolean> emVolta ;

    private TreeSet<Registro> registros_fv ;





    public CronometragemTreino(TreeSet<Loop> loops) {
        super(loops);
        registros_fv = new TreeSet<Registro>( descTimeR ) ;
        emVolta = new HashMap<Transponder, Boolean>();
        trp_vlt_sect_rgt = new HashMap<Transponder, TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>>();

        Comparator<ScoreBoardRTRegistro> sbc = new Comparator<ScoreBoardRTRegistro>() {

            public int compare(ScoreBoardRTRegistro sbr1, ScoreBoardRTRegistro sbr2) {

                Long sbr1t = sbr1.getTempo_melhor_Volta().get(1) == null?Long.MAX_VALUE:sbr1.getTempo_melhor_Volta().get(1);
                Long sbr2t = sbr2.getTempo_melhor_Volta().get(1) == null?Long.MAX_VALUE:sbr2.getTempo_melhor_Volta().get(1);

                int difT = (int)(sbr1t - sbr2t) ;

                if(difT != 0){
                    return difT;
                }
                else{
                    return sbr1.getNomePiloto().compareTo(sbr2.getNomePiloto());
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
                        if(sbr.getPiloto().getID()==rp.getID()){
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
                        sbr.setPit(true);
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

                        CronometragemRegistro cr = new CronometragemRegistro(nReg, nPiloto, nmEquipa, nmPiloto, transponderRef, sector, loopRef, tempo, tempoProva, tempoMedicao, potenciaSinal, hits, volta, false);
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
                            TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer,CronometragemRegistro>();
                            trp_vlt_sect_rgt.get(rt).put(volta+1,sectores);
                            /// /// ///

                            sbr.setVolta(volta+1);

                            long tempoVolta = 0;

                            for(long tempoSector : sbr.getTempos_sectors_ultimo().values()){
                                tempoVolta += tempoSector;
                            }

                            sbr.setTempo_ultima_volta(tempoVolta);

                            _time = sbr.getTempo_melhor_Volta();

                            if(_time.containsKey(1)){
                                if(_time.get(1).compareTo(tempoVolta)>0){
                                    _time.put(1,tempoVolta);
                                }
                            }
                            else{
                                _time.put(1,tempoVolta);
                            }
                        }
                    }
                    sb.add(sbr);
                    refresh();
                    /////////////
                }
                else{
                    registros_fv.add(r);
                }
            }
            else{
                emVolta.put(rt,rl.equals(finishLine));
                TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>> voltas = new TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>();
                TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer, CronometragemRegistro>();
                voltas.put(1,sectores);
                trp_vlt_sect_rgt.put(rt,voltas);
                registros_fv.add(r);
            }
            inicioSector.put(rt,r);
        }
        else{
            registros_na.add(r);
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

        long time_gap_primeiro = sbr.getTempo_melhor_Volta().get(1) == null?Long.MAX_VALUE:sbr.getTempo_melhor_Volta().get(1) ;
        long time_gap_frente = time_gap_primeiro;

        for(ScoreBoardRTRegistro sbr_ : sb){
            long diff_u_p = sbr_.getTempo_ultima_volta() - time_u_primeiro ;
            long diff_u_f = sbr_.getTempo_ultima_volta() - time_u_anterior ;

            long diff_m_p = sbr_.getTempo_melhor_Volta().get(1)==null? 0 : sbr_.getTempo_melhor_Volta().get(1) - time_gap_primeiro ;
            long diff_m_f = sbr_.getTempo_melhor_Volta().get(1)==null? 0 : sbr_.getTempo_melhor_Volta().get(1) - time_gap_frente ;

            if(diff_m_f == 0){
                sbr_.setPosicao(posicao_a);
            }
            else{
                sbr_.setPosicao(count);
                posicao_a = count;
            }

            sbr_.setDiff_u_primeiro(diff_u_p);
            sbr_.setDiff_u_frente(diff_u_f);
            sbr_.setDiff_gap_primeiro(diff_m_p);
            sbr_.setDiff_gap_frente(diff_m_f);

            count++;

            time_u_anterior = sbr_.getTempo_ultima_volta() ;
            time_gap_frente = sbr_.getTempo_melhor_Volta().get(1) == null?Long.MAX_VALUE:sbr_.getTempo_melhor_Volta().get(1);
        }

    }






}
