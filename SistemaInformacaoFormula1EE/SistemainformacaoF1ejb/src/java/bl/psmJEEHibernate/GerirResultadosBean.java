/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import POJOs.ResCampEquipa;
import POJOs.ResCampEquipas;
import POJOs.ResCampEventoCorr;
import POJOs.ResCampEventoQual;
import POJOs.ResCampEventoTreinos;
import POJOs.ResCampEventos;
import POJOs.ResCampPiloto;
import POJOs.ResCampPilotos;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Qualificacao;
import bl.psmJEEHibernate.entities.Qualificativa;
import bl.psmJEEHibernate.entities.ResultadoCorrida;
import bl.psmJEEHibernate.entities.ResultadoQualificacao;
import bl.psmJEEHibernate.entities.ResultadoTreino;
import bl.psmJEEHibernate.entities.Treino;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tiago
 */
@Stateful
public class GerirResultadosBean implements GerirResultadosRemote, GerirResultadosLocal {
    @PersistenceContext
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void edit(Object object){
        em.merge(object);
    }

    public void remove(Object object){
        em.remove(em.merge(object));
    }

    // por campeonato, por equipa
    public ArrayList<ResCampEquipa> getResCampEquipa(String camp, String nomeEquip){
        ArrayList<ResCampEquipa> rce = new ArrayList<ResCampEquipa>();
        try {
            ArrayList<Evento> evts = (ArrayList<Evento>) em.createQuery("SELECT DISTINCT Object(e) FROM Evento AS e LEFT JOIN FETCH e.campeonato c LEFT JOIN FETCH e.corrida o LEFT JOIN FETCH o.resultados r LEFT JOIN FETCH r.equipa LEFT JOIN FETCH r.piloto WHERE c.designacao='"+camp+"'").getResultList();


            for(Evento e:evts){
                ArrayList<ResultadoCorrida> rc = new ArrayList<ResultadoCorrida>();
                int pontos = 0;

                Corrida c = (Corrida) em.createQuery("SELECT Object(c) FROM Corrida c LEFT JOIN FETCH c.resultados WHERE c.ID="+e.getCorrida().getID()).getSingleResult();
                rc.addAll(c.getResultados());

                for(ResultadoCorrida r:rc){
                    if (nomeEquip.equals(r.getEquipa().getNome())){
                        pontos += r.getPontos();
                    }
                }
                ResCampEquipa resCamEquip = new ResCampEquipa(e.getDesignacao(), c.getData(), pontos);
                if (!rce.contains(resCamEquip)) rce.add(resCamEquip);
            }

            Comparator comparator = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampEquipa u1 = (ResCampEquipa) o1;
                    ResCampEquipa u2 = (ResCampEquipa) o2;
                    return u2.getData().compareTo(u1.getData());


                }
            };
            Collections.sort(rce, comparator);

            return rce;

        } catch(Exception ex) { return rce; }
    }

    // por campeonato, todas as equipas
    public ArrayList<ResCampEquipas> getResCampEquipas(String camp){
        ArrayList<ResCampEquipas> rces = new ArrayList<ResCampEquipas>();
        ArrayList<Equipa> equipas = new ArrayList<Equipa>(((Campeonato) em.createQuery("SELECT Object(c) FROM Campeonato AS c LEFT JOIN FETCH c.equipas WHERE c.designacao='"+camp+"'").getSingleResult()).getEquipas());

        for(Equipa e:equipas){
            ArrayList<ResCampEquipa> rce = new ArrayList<ResCampEquipa>();
            rce = getResCampEquipa(camp, e.getNome());
            int pontos = 0;

            for(ResCampEquipa r:rce)
                pontos += r.getPontos();

            rces.add(new ResCampEquipas(e.getNome(), pontos));
        }

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                ResCampEquipas u1 = (ResCampEquipas) o1;
                ResCampEquipas u2 = (ResCampEquipas) o2;
                return new Integer(u2.getPontos()).compareTo(new Integer(u1.getPontos()));


            }
        };
        Collections.sort(rces, comparator);

        ArrayList<ResCampEquipas> res = new ArrayList<ResCampEquipas>();

        int pos = 0;
        int aux = 0;
        for(int i=0; i<rces.size(); i++){
            if (i>0 && rces.get(i-1).getPontos()==rces.get(i).getPontos()){
                aux++;
                ResCampEquipas r = rces.get(i);
                r.setPosicao(pos);
                res.add(r);
            }
            else{
                pos = pos + 1 + aux;
                aux = 0;
                ResCampEquipas r = rces.get(i);
                r.setPosicao(pos);
                res.add(r);
            }
        }

        return res;
    }

    // por campeonato, por piloto
    public ArrayList<ResCampPiloto> getResCampPiloto(String camp, String nomePiloto){
        ArrayList<ResCampPiloto> rcp = new ArrayList<ResCampPiloto>();
        try {

            ArrayList<Evento> evts = (ArrayList<Evento>) em.createQuery("SELECT DISTINCT Object(e) FROM Evento AS e LEFT JOIN FETCH e.campeonato c LEFT JOIN FETCH e.corrida o LEFT JOIN FETCH o.resultados r LEFT JOIN FETCH r.equipa LEFT JOIN FETCH r.piloto WHERE c.designacao='"+camp+"'").getResultList();

            for(Evento e:evts){
                ArrayList<ResultadoCorrida> rc = new ArrayList<ResultadoCorrida>();
                String equipa = "";
                int grelha = 0;
                int posicao = 0;
                int pontos = 0;

                Corrida c = (Corrida) em.createQuery("SELECT Object(c) FROM Corrida c LEFT JOIN FETCH c.resultados WHERE c.ID="+e.getCorrida().getID()).getSingleResult();
                rc.addAll(c.getResultados());

                for(ResultadoCorrida r:rc){
                    if (nomePiloto.equals(r.getPiloto().getNome())){
                        equipa = r.getEquipa().getNome();
                        grelha = r.getPosicaoGrelha();
                        posicao = r.getPosicao();
                        pontos = r.getPontos();
                        break;
                    }
                }
                ResCampPiloto resCampPil = new ResCampPiloto(e.getDesignacao(), e.getData(), equipa, grelha, posicao, pontos);
                if (!rcp.contains(resCampPil)) rcp.add(resCampPil);
            }

            Comparator comparator = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampPiloto u1 = (ResCampPiloto) o1;
                    ResCampPiloto u2 = (ResCampPiloto) o2;
                    return u2.getData().compareTo(u1.getData());


                }
            };
            Collections.sort(rcp, comparator);

            return rcp;

        } catch(Exception ex) { return rcp; }

    }

    // por campeonato, todos os pilotos
    public ArrayList<ResCampPilotos> getResCampPilotos(String camp){
        ArrayList<ResCampPilotos> rcps = new ArrayList<ResCampPilotos>();
        ArrayList<Equipa> equipas = new ArrayList<Equipa>(((Campeonato) em.createQuery("SELECT Object(c) FROM Campeonato AS c LEFT JOIN FETCH c.equipas WHERE c.designacao='"+camp+"'").getSingleResult()).getEquipas());
        HashMap<Piloto, String> pilotos = new HashMap<Piloto, String>();
        for(Equipa e:equipas)
            for(Piloto p:e.getPilotos())
                pilotos.put(p, e.getNome());

        for(Piloto p:pilotos.keySet()){
            ArrayList<ResCampPiloto> rcp = new ArrayList<ResCampPiloto>();
            rcp = getResCampPiloto(camp, p.getNome());
            int pontos = 0;

            for(ResCampPiloto r:rcp)
                pontos += r.getPontos();

            rcps.add(new ResCampPilotos(p.getNome(), p.getNacionalidade(), pilotos.get(p), pontos));
        }

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                ResCampPilotos u1 = (ResCampPilotos) o1;
                ResCampPilotos u2 = (ResCampPilotos) o2;
                return new Integer(u2.getPontos()).compareTo(new Integer(u1.getPontos()));


            }
        };
        Collections.sort(rcps, comparator);

        ArrayList<ResCampPilotos> res = new ArrayList<ResCampPilotos>();

        int pos = 0;
        int aux = 0;
        for(int i=0; i<rcps.size(); i++){
            if (i>0 && rcps.get(i-1).getPontos()==rcps.get(i).getPontos()){
                aux++;
                ResCampPilotos r = rcps.get(i);
                r.setPosicao(pos);
                res.add(r);
            }
            else{
                pos = pos + 1 + aux;
                aux = 0;
                ResCampPilotos r = rcps.get(i);
                r.setPosicao(pos);
                res.add(r);
            }
        }

        return res;
    }


    // por campeonato, por evento, todas as corridas
    public ArrayList<ResCampEventoCorr> getResCampEventoCorr(String camp, String evt){
        ArrayList<ResCampEventoCorr> rcec = new ArrayList<ResCampEventoCorr>();
        try{
            Evento evento = (Evento) em.createQuery("SELECT DISTINCT Object(e) FROM Evento AS e LEFT JOIN FETCH e.campeonato c LEFT JOIN FETCH e.corrida o LEFT JOIN FETCH o.resultados r WHERE c.designacao='"+camp+"' AND e.designacao='"+evt+"'").getSingleResult();

            Corrida c = (Corrida) em.createQuery("SELECT Object(c) FROM Corrida c LEFT JOIN FETCH c.resultados r LEFT JOIN FETCH r.piloto WHERE c.ID="+evento.getCorrida().getID()).getSingleResult();
            ArrayList<ResultadoCorrida> rcs = new ArrayList<ResultadoCorrida>();

            for(ResultadoCorrida rc:c.getResultados()){
                ResultadoCorrida resC = (ResultadoCorrida) em.createQuery("SELECT Object(r) FROM ResultadoCorrida AS r LEFT JOIN FETCH r.piloto LEFT JOIN FETCH r.equipa WHERE r.ID="+rc.getID()).getSingleResult();
                rcs.add(resC);
            }

            for(ResultadoCorrida r:rcs){
                ResCampEventoCorr resCEC = new ResCampEventoCorr(r.getPiloto().getNumero(), r.getPiloto().getNome(), r.getEquipa().getNome(), r.getVoltas(), r.getTempo(), r.getPosicaoGrelha(), r.getPontos());
                if (!rcec.contains(resCEC)) rcec.add(resCEC);
            }

            Comparator comparator = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampEventoCorr u1 = (ResCampEventoCorr) o1;
                    ResCampEventoCorr u2 = (ResCampEventoCorr) o2;
                    return new Long(u1.getTempo()).compareTo(new Long(u2.getTempo()));


                }
            };
            Collections.sort(rcec, comparator);

            ArrayList<ResCampEventoCorr> res = new ArrayList<ResCampEventoCorr>();

            int pos = 0;
            int aux = 0;
            for(int i=0; i<rcec.size(); i++){
                if (i>0 && rcec.get(i-1).getTempo()==rcec.get(i).getTempo()){
                    aux++;
                    ResCampEventoCorr r = rcec.get(i);
                    r.setPosicao(pos);
                    res.add(r);
                }
                else{
                    pos = pos + 1 + aux;
                    aux = 0;
                    ResCampEventoCorr r = rcec.get(i);
                    r.setPosicao(pos);
                    res.add(r);
                }
            }


            return res;

        } catch(Exception ex) { return rcec; }
    }

    // por campeonato, todos eventos
    public ArrayList<ResCampEventos> getResCampEventos(String camp){
        System.out.println(camp);
        ArrayList<Evento> eventos = (ArrayList<Evento>) em.createQuery("SELECT DISTINCT Object(e) FROM Evento AS e LEFT JOIN FETCH e.campeonato c WHERE c.designacao='"+camp+"'").getResultList();
        ArrayList<ResCampEventos> rces = new ArrayList<ResCampEventos>();

        for(Evento evt:eventos){
            ResCampEventoCorr rcec = getResCampEventoCorr(camp, evt.getDesignacao()).get(0);
            ResCampEventos rce = new ResCampEventos(evt.getDesignacao(), evt.getData(), rcec.getPiloto(), rcec.getEquipa(), rcec.getVoltas(), rcec.getTempo());
            rces.add(rce);
        }

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                ResCampEventos u1 = (ResCampEventos) o1;
                ResCampEventos u2 = (ResCampEventos) o2;
                return u2.getData().compareTo(u1.getData());
            }
        };
        Collections.sort(rces, comparator);

        return rces;
    }


        // por campeonato, por evento, todas as qualificaÃ§Ãµes
    public ArrayList<ResCampEventoQual> getResCampEventoQual(String camp, String evt){
        ArrayList<ResCampEventoQual> rceq = new ArrayList<ResCampEventoQual>();
        try{
            ArrayList<Evento> eventos = new ArrayList<Evento>(((Campeonato) em.createQuery("SELECT DISTINCT Object(c) FROM Campeonato AS c LEFT JOIN FETCH c.eventos WHERE c.designacao='"+camp+"'").getSingleResult()).getEventos());
            ArrayList<Qualificacao> qs = new ArrayList<Qualificacao>();
            Evento evento = new Evento();
            for(Evento e:eventos)
                if (e.getDesignacao().equals(evt)){
                    evento = e;
                    break;
                }

            Qualificacao q = new Qualificacao();
            q = ((Evento) em.createQuery("SELECT Object(e) FROM Evento AS e LEFT JOIN FETCH e.qualificacao q LEFT JOIN FETCH q.resultados WHERE e.ID="+evento.getID()).getSingleResult()).getQualificacao();


            for(ResultadoQualificacao rq:q.getResultados()){

                ResultadoQualificacao resQual = new ResultadoQualificacao();
                resQual = (ResultadoQualificacao) em.createQuery("SELECT Object(r) FROM ResultadoQualificacao r LEFT JOIN FETCH r.qualificativas LEFT JOIN FETCH r.piloto LEFT JOIN FETCH r.equipa WHERE r.ID="+rq.getID()).getSingleResult();
                ArrayList<Qualificativa> quals = new ArrayList<Qualificativa>(resQual.getQualificativas());
                long t1 = 0, t2 = 0, t3 = 0;
                for(Qualificativa qv:quals){
                    if (qv.getSessao()==1) t1=qv.getTempo();
                    if (qv.getSessao()==2) t2=qv.getTempo();
                    if (qv.getSessao()==3) t3=qv.getTempo();
                }
                ResCampEventoQual res = new ResCampEventoQual(resQual.getPiloto().getNumero(), resQual.getPiloto().getNome(), resQual.getEquipa().getNome(), t1, t2, t3, resQual.getVoltas());
                rceq.add(res);
            }

            ArrayList<ResCampEventoQual> rceq_qs_3 = new ArrayList<ResCampEventoQual>();
            for(ResCampEventoQual r_qs3:rceq)
                if (r_qs3.getQual_3()!=0) rceq_qs_3.add(r_qs3);

            Comparator comparator = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampEventoQual u1 = (ResCampEventoQual) o1;
                    ResCampEventoQual u2 = (ResCampEventoQual) o2;
                    return new Long(u1.getQual_3()).compareTo(new Long(u2.getQual_3()));
                }
            };
            Collections.sort(rceq_qs_3, comparator);

            ArrayList<ResCampEventoQual> rceq_qs_2 = new ArrayList<ResCampEventoQual>();
            for(ResCampEventoQual r_qs2:rceq)
                if (r_qs2.getQual_2()!=0 && r_qs2.getQual_3()==0) rceq_qs_2.add(r_qs2);

            Comparator comparator2 = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampEventoQual u1 = (ResCampEventoQual) o1;
                    ResCampEventoQual u2 = (ResCampEventoQual) o2;
                    return new Long(u1.getQual_2()).compareTo(new Long(u2.getQual_2()));
                }
            };
            Collections.sort(rceq_qs_2, comparator2);

            ArrayList<ResCampEventoQual> rceq_qs_1 = new ArrayList<ResCampEventoQual>();
            for(ResCampEventoQual r_qs1:rceq)
                if (r_qs1.getQual_1()!=0 && r_qs1.getQual_2()==0 && r_qs1.getQual_3()==0) rceq_qs_1.add(r_qs1);

            Comparator comparator3 = new Comparator() {
                public int compare(Object o1, Object o2) {
                    ResCampEventoQual u1 = (ResCampEventoQual) o1;
                    ResCampEventoQual u2 = (ResCampEventoQual) o2;
                    return new Long(u1.getQual_1()).compareTo(new Long(u2.getQual_1()));
                }
            };
            Collections.sort(rceq_qs_1, comparator3);

            ArrayList<ResCampEventoQual> res = new ArrayList<ResCampEventoQual>();
            res.addAll(rceq_qs_3);
            res.addAll(rceq_qs_2);
            res.addAll(rceq_qs_1);

            int i = 1;
            for(ResCampEventoQual r:res){
                r.setPosicao(i);
                i++;
            }

            return res;

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return rceq;

    }

    // por campeonato, por evento, todos os treinos
    public ArrayList<ArrayList<ResCampEventoTreinos>> getResCampEventoTreinos(String camp, String evt){
        ArrayList<ArrayList<ResCampEventoTreinos>> rcet = new ArrayList<ArrayList<ResCampEventoTreinos>>();
        try{
            ArrayList<Evento> eventos = new ArrayList<Evento>(((Campeonato) em.createQuery("SELECT DISTINCT Object(c) FROM Campeonato AS c LEFT JOIN FETCH c.eventos WHERE c.designacao='"+camp+"'").getSingleResult()).getEventos());

            Evento evento = new Evento();
            for(Evento e:eventos)
                if (e.getDesignacao().equals(evt)){
                    evento = e;
                    break;
                }

            ArrayList<Treino> ts = new ArrayList<Treino>();
            ts = new ArrayList<Treino>(((Evento) em.createQuery("SELECT Object(e) FROM Evento AS e LEFT JOIN FETCH e.treinos t WHERE e.ID="+evento.getID()).getSingleResult()).getTreinos());

            Comparator comparatorT = new Comparator() {
                public int compare(Object o1, Object o2) {
                     Treino u1 = (Treino) o1;
                     Treino u2 = (Treino) o2;
                     return new Date(u1.getData().getTime()).compareTo(new Date(u2.getData().getTime()));
                }
            };
            Collections.sort(ts, comparatorT);

            for(Treino t:ts){
                ArrayList<ResultadoTreino> rt = new ArrayList<ResultadoTreino>();
                rt = new ArrayList<ResultadoTreino>(((Treino) em.createQuery("SELECT Object(o) FROM Treino AS o LEFT JOIN FETCH o.resultados WHERE o.ID="+t.getID()).getSingleResult()).getResultados());
                ArrayList<ResultadoTreino> rts = new ArrayList<ResultadoTreino>();
                for(ResultadoTreino r:rt){
                    ResultadoTreino resT = new ResultadoTreino();
                    resT = (ResultadoTreino) em.createQuery("SELECT Object(o) FROM ResultadoTreino AS o LEFT JOIN FETCH o.piloto LEFT JOIN FETCH o.equipa WHERE o.ID="+r.getID()).getSingleResult();
                    rts.add(resT);
                }
                ArrayList<ResCampEventoTreinos> resCETs = new ArrayList<ResCampEventoTreinos>();
                for(ResultadoTreino res:rts){
                    ResCampEventoTreinos resCET = new ResCampEventoTreinos(res.getPiloto().getNumero(), res.getPiloto().getNome(), res.getEquipa().getNome(), res.getTempo(), res.getVoltas());
                    resCETs.add(resCET);
                }

                Comparator comparator = new Comparator() {
                    public int compare(Object o1, Object o2) {
                     ResCampEventoTreinos u1 = (ResCampEventoTreinos) o1;
                     ResCampEventoTreinos u2 = (ResCampEventoTreinos) o2;
                     return new Long(u1.getTempo()).compareTo(new Long(u2.getTempo()));
                    }
                };
                Collections.sort(resCETs, comparator);

                ArrayList<ResCampEventoTreinos> res = new ArrayList<ResCampEventoTreinos>();

                int pos = 0;
                int aux = 0;
                for(int i=0; i<resCETs.size(); i++){
                    if (i>0 && resCETs.get(i-1).getTempo()==resCETs.get(i).getTempo()){
                        aux++;
                        ResCampEventoTreinos r = resCETs.get(i);
                        r.setPosicao(pos);
                        res.add(r);
                    }
                    else{
                        pos = pos + 1 + aux;
                        aux = 0;
                        ResCampEventoTreinos r = resCETs.get(i);
                        r.setPosicao(pos);
                        res.add(r);
                    }
                }

                rcet.add(resCETs);
            }

        } catch (Exception ex) {}

        return rcet;

    }



}
