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


public class CronometragemCorrida extends CronometragemAbstract
implements Serializable {


   private HashMap<Transponder,TreeMap<Integer,TreeMap<Integer,CronometragemRegistro>>> trp_vlt_sect_rgt ;

   private int nVoltas;

   private boolean fimDeCorrida;

   private HashMap<Transponder,Boolean> finished;




   public CronometragemCorrida(TreeSet<Loop> loops, int nVoltas) {
       super(loops);
       trp_vlt_sect_rgt = new HashMap<Transponder, TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>>();
       this.nVoltas = nVoltas;
       fimDeCorrida = false;
       finished = new HashMap<Transponder, Boolean>();


       Comparator<ScoreBoardRTRegistro> sbc = new Comparator<ScoreBoardRTRegistro>() {

           public int compare(ScoreBoardRTRegistro sbr1, ScoreBoardRTRegistro sbr2) {

               int difVoltas = sbr2.getVolta() - sbr1.getVolta();


               if(difVoltas != 0){
                   return difVoltas;
               }
               else{
                   long difTempo = sbr1.getTempo_acumulado()-sbr2.getTempo_acumulado();
                   if(difTempo != 0){
                       return (int)difTempo;
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



           if(trp_vlt_sect_rgt.containsKey(rt)){
               if(!finished.get(rt)){

                   int nReg = nRegistro++;
                   Piloto rp = rt.getPiloto();
                   int nPiloto = rp.getNumero();
                   Equipa re = rp.getEquipa_actual();
                   String nmEquipa = re.getNome();
                   String nmPiloto = rp.getNome();
                   String transponderRef = rt.getRef();
                   Entry<Integer,TreeMap<Integer,CronometragemRegistro>> voltaEntry = trp_vlt_sect_rgt.get(rt).lastEntry();
                   Entry<Integer,CronometragemRegistro> sectorEntry = voltaEntry.getValue().lastEntry();
                   int sector = sectorEntry == null?1:sectorEntry.getKey()+1;
                   String loopRef = rl.getRef();
                   long tempo = r.getTempoTransponder().getTime() - inicioSector.get(rt).getTempoTransponder().getTime() ;
                   long tempoProva = r.getTempoTransponder().getTime() - inicio.getTime() ;
                   Date tempoMedicao = r.getTempoTransponder();

                   int potenciaSinal = r.getPotenciaSinal();
                   int hits = r.getHits();

                   int volta = voltaEntry.getKey();
                   boolean pit = rl.equals(box);

                   CronometragemRegistro cr = new CronometragemRegistro(nReg, nPiloto, nmEquipa, nmPiloto, transponderRef, sector, loopRef, tempo, tempoProva, tempoMedicao, potenciaSinal, hits, volta, pit);
                   registros.add(cr);




                   ///////////////////////////////////
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

                   sbr.getTempos_sectors_ultimo().put(sector, tempo);
                   sbr.setPit(pit);
                   if(pit){
                       sbr.setPitCount(sbr.getPitCount()+1);
                   }

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

                   //////////////////////////

                   voltaEntry.getValue().put(sector,cr);

                   if(pit || rl.equals(finishLine)){

                       if(fimDeCorrida){
                           finished.put(rt,true);
                           boolean nActivo = false;
                           for(Boolean b : finished.values()){
                               nActivo = nActivo || (!b);
                           }
                           activo = nActivo;
                       }
                       else{
                           if(volta == nVoltas){
                               fimDeCorrida = true;
                               finished.put(rt,true);
                           }
                           else{
                               TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer, CronometragemRegistro>();
                               trp_vlt_sect_rgt.get(rt).put(volta+1,sectores);
                           }
                       }
                       //////////////////////////////////
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
                               sbr.setMelhor_volta(volta);
                           }
                       }
                       else{
                           _time.put(1,tempoVolta);
                       }
                   }
                   sb.add(sbr);
                   refresh();
                   ///////////////////////////
               }

           }
           else{
               TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>> voltas = new TreeMap<Integer, TreeMap<Integer, CronometragemRegistro>>();
               TreeMap<Integer, CronometragemRegistro> sectores = new TreeMap<Integer, CronometragemRegistro>();
               voltas.put(1,sectores);
               trp_vlt_sect_rgt.put(rt,voltas);
               finished.put(rt,false);
           }

           inicioSector.put(rt,r);

       }
       else{
           registros_na.add(r);
       }

   }


   public void retire(Transponder t){
       finished.put(t,true);
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

       int volta_p = sbr.getVolta() ;
       int volta_f = volta_p;


       long time_u_primeiro = sbr.getTempo_ultima_volta();
       long time_u_anterior = time_u_primeiro;

       long time_gap_primeiro = sbr.getTempo_acumulado();
       long time_gap_frente = time_gap_primeiro;


       for(ScoreBoardRTRegistro sbr_ : sb){
           long diff_u_p = Math.abs(sbr_.getTempo_ultima_volta() - time_u_primeiro) ;
           long diff_u_f = Math.abs(sbr_.getTempo_ultima_volta() - time_u_anterior) ;

           long diff_gap_p ;
           long diff_gap_f ;

           if(sbr_.getVolta() == volta_p){
               diff_gap_p = sbr_.getTempo_acumulado() - time_gap_primeiro ;
           }
           else{
               diff_gap_p = sbr_.getVolta()-volta_p;
           }

           if(sbr_.getVolta() == volta_f){
               diff_gap_f = sbr_.getTempo_acumulado() - time_gap_frente ;
           }
           else{
               diff_gap_f = sbr_.getVolta()-volta_f;
           }

           if(diff_gap_f == 0){
               sbr_.setPosicao(posicao_a);
           }
           else{
               sbr_.setPosicao(count);
               posicao_a = count;
           }


           sbr_.setDiff_u_primeiro(diff_u_p);
           sbr_.setDiff_u_frente(diff_u_f);
           sbr_.setDiff_gap_primeiro(diff_gap_p);
           sbr_.setDiff_gap_frente(diff_gap_f);

           count++;

           volta_f = sbr_.getVolta();

           time_u_anterior = sbr_.getTempo_ultima_volta() ;
           time_gap_frente = sbr_.getTempo_acumulado() ;
       }

   }






}
