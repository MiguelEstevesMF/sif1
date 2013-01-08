/*
 * ApplicationBean1.java
 *
 * Created on 28/Jun/2009, 22:21:37
 * Copyright Miguel
 */
package sistemainformacaoformula1.aplicacoes;

import bl.psmJEEHibernate.GerirCampeonatoLocal;
import bl.psmJEEHibernate.GerirCircuitoLocal;
import bl.psmJEEHibernate.GerirEquipaLocal;
import bl.psmJEEHibernate.GerirPilotoLocal;
import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.TempoReal.RunningSessions;
import bl.psmJEEHibernate.entities.Admin;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Circuito;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Ocorrencia;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Qualificacao;
import bl.psmJEEHibernate.entities.Qualificativa;
import bl.psmJEEHibernate.entities.ResultadoCorrida;
import bl.psmJEEHibernate.entities.ResultadoQualificacao;
import bl.psmJEEHibernate.entities.ResultadoTreino;
import bl.psmJEEHibernate.entities.SBTR;
import bl.psmJEEHibernate.entities.Transponder;
import bl.psmJEEHibernate.entities.Treino;
import bl.psmJEEHibernate.entities.Utilizador;
import sistemainformacaoformula1.*;
import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.FacesException;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class InicializadorApplicationBean extends AbstractApplicationBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    @EJB
    private GerirUtilizadorLocal gur;

    @EJB
    private GerirCampeonatoLocal gcr;

    @EJB
    private GerirEquipaLocal ger;

    @EJB
    private GerirCircuitoLocal gcirr;

    @EJB
    private GerirPilotoLocal gpr;

    private boolean init = false;


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public InicializadorApplicationBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     *
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

        System.out.println("inicializadorapplicationbean");

        RunningSessions.getInstance();
        ///////////////////////////////////////////////////
        init=true; //desligado
        if(init) return;


        synchronized (this) {

            initUtilzadores();

            initCircuitos();
            initPilotos();

            initCampeonatos();

            init=true;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="initCampeonatos">
    public void initCampeonatos(){

        ArrayList<Campeonato> camps = new ArrayList<Campeonato>();
        HashSet<Equipa> equipas = new HashSet(ger.getEquipas());
        HashSet<Evento> eventos = new HashSet<Evento>();
        Campeonato c;

        for(int i=1;i<30;i++) {
            c = new Campeonato();
            createCampeonato(c,"campeonato"+i, 2000+i, 2001+i,equipas,eventos);

            ArrayList<Circuito> circuitos = (ArrayList<Circuito>) gcirr.getCircuitos();
            eventos = new HashSet<Evento>();
            int v = 60;

            for(int j=1;j<10;j++) {
                HashSet<Treino> treinos = new HashSet<Treino>();
                Circuito cir = circuitos.get((circuitos.size()-1) %i);
                Corrida corr = new Corrida();
                Treino treino = new Treino();
                Qualificacao q = new Qualificacao();

                HashSet<ResultadoCorrida> resCorr = new HashSet<ResultadoCorrida>();
                HashSet<ResultadoQualificacao> resQual = new HashSet<ResultadoQualificacao>();
                HashSet<ResultadoTreino> resTreino = new HashSet<ResultadoTreino>();

                Random voltas = new Random();
                v = voltas.nextInt(20)+51;

                int a=1;
                for(Equipa eqA : ger.getEquipas()) {

                    Equipa eq = ger.getEquipaP(eqA.getNome());

                    for(Piloto p : eq.getPilotos()) {

                        ResultadoCorrida rc = new ResultadoCorrida();

                        Random tp = new Random();
                        int tempo = tp.nextInt(500000)+3000000;
                        rc.setEquipa(eq);
                        rc.setPiloto(p);
                        rc.setPosicao(0);
                        rc.setVoltas(v);
                        rc.setTempo((a*50000)+tempo);
                        rc.setPosicaoGrelha(a);
                        rc.setVoltaMelhorTempo(a*2);
                        rc.setVelocidadeMedia(a*50);
                        rc.setTempoMelhorVolta(a*j*1222 / 2);

                        resCorr.add(rc);


                        ResultadoQualificacao rq = new ResultadoQualificacao();

                        rq.setEquipa(eq);
                        rq.setPiloto(p);
                        rq.setTempo((long) ((j*a*1000+10000)/2));
                        rq.setVoltas((int) (j*a/2));

                        ArrayList<Qualificativa> quals = new ArrayList<Qualificativa>();
                        Qualificativa q1 = new Qualificativa();
                        q1.setSessao(1);
                        q1.setTempo(j*a*600);
                        Qualificativa q2 = new Qualificativa();
                        q2.setSessao(2);
                        if (a>6) q2.setTempo(0);
                        else q2.setTempo(j*a*700);
                        Qualificativa q3 = new Qualificativa();
                        q3.setSessao(3);
                        if (a>3) q3.setTempo(0);
                        else q3.setTempo(j/a*500);
                        quals.add(q1);
                        quals.add(q2);
                        quals.add(q3);
                        rq.setQualificativas(new HashSet<Qualificativa>(quals));

                        resQual.add(rq);


                        ResultadoTreino rt = new ResultadoTreino();
                        rt.setEquipa(eq);
                        rt.setPiloto(p);
                        rt.setPosicao(a);
                        rt.setTempo((long) ((j*a*1000+8000)/2));
                        rt.setVoltas((int) (j+a));


                        resTreino.add(rt);


                        a++;
                    }

                }

                ArrayList<ResultadoCorrida> resCorr_array = new ArrayList<ResultadoCorrida>(resCorr);

                Comparator comparator = new Comparator() {
                    public int compare(Object o1, Object o2) {
                        ResultadoCorrida u1 = (ResultadoCorrida) o1;
                        ResultadoCorrida u2 = (ResultadoCorrida) o2;
                        return new Long(u1.getTempo()).compareTo(new Long(u2.getTempo()));


                    }
                };
                Collections.sort(resCorr_array, comparator);

                ArrayList<ResultadoCorrida> res_corr = new ArrayList<ResultadoCorrida>();

                int pontos = 10;
                for(ResultadoCorrida res_cor:resCorr_array){
                    res_cor.setPontos(pontos);
                    if (pontos>0 && pontos<=6) pontos--;
                    else if(pontos>6) pontos=pontos-2;
                    res_corr.add(res_cor);
                }

                Random random = new Random();
                int n_t = random.nextInt(9)+1;
                if (n_t>0 && n_t<4){
                    treino.setResultados(resTreino);
                    treino.setData(new GregorianCalendar(2000+i,0+j,10+j,6+1,15+j).getTime());
                    treinos.add(treino);
                }

                corr.setResultados(new HashSet<ResultadoCorrida>(res_corr));
                q.setResultados(resQual);


                corr.setData(new GregorianCalendar(2000+i,0+j,13+j,14+1,30+j).getTime());
                q.setData(new GregorianCalendar(2000+i,0+j,12+j,11+1,30+j).getTime());

                Evento e = new Evento("evento"+j+"_c"+i,new GregorianCalendar(2000+i,0+j,13).getTime(),56,5.6f,cir,corr,q,treinos,c);
                eventos.add(e);
            }

            c.setEventos(eventos);
            camps.add(c);

        }

        gcr.setCampeonatos(camps);

    }


    public void createCampeonato(Campeonato c, String designacao,int anoi,int anof,HashSet<Equipa> equipas,HashSet<Evento> eventos){
        c.setDesignacao(designacao);
        c.setAnoInicio(anoi);
        c.setAnoFim(anof);
        c.setEquipas(equipas);
        c.setEventos(eventos);
    }




    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="initCircuitos">
    public void initCircuitos(){
        Circuito c = new Circuito();
        HashSet<Loop> loops = new HashSet<Loop>();
        addLoop(loops, (float) 3.0, "e_s1");
        addLoop(loops, (float) 1.2, "e_s2");
        addLoop(loops, (float) 2.0, "e_s3");
        addLoop(loops, (float) 0.8, "e_s4");
        createCircuito(c, "Cascais", (float) 7.0, "Circuito do Estoril, localizado em Cascais", 0, "http://www.circuito-estoril.pt/", (float) 15.5, "AutÃ³dromo do Estoril", "Portugal", loops);
        gcirr.addCircuito(c);

        c = new Circuito();
        loops = new HashSet<Loop>();
        addLoop(loops, (float) 3.5, "b_s1");
        createCircuito(c, "Braga", (float) 3.5, "", 0, "", (float) 10.2, "AutÃ³dromo Vasco Sameiro", "Portugal", loops);
        gcirr.addCircuito(c);

        c = new Circuito();
        loops = new HashSet<Loop>();
        addLoop(loops, (float) 1.3, "s_s1");
        addLoop(loops, (float) 1.5, "s_s2");
        addLoop(loops, (float) 2.5, "s_s3");
        createCircuito(c, "Sidney", (float) 5.3, "Circuito de Sidney inserido no campeonato de F1", 11, "http://www.formula1.com/races/in_detail/australia_805/circuit_diagram.html", (float) 20, "Australian Grand Prix", "Australia", loops);
        gcirr.addCircuito(c);

        c = new Circuito();
        loops = new HashSet<Loop>();
        addLoop(loops, (float) 0.9, "m_s1");
        addLoop(loops, (float) 2.1, "m_s2");
        addLoop(loops, (float) 1.6, "m_s3");
        createCircuito(c, "Madrid", (float) 4.6, "Circuito de Madrid inserido no campeonato de F1", 1, "http://www.formula1.com/races/in_detail/spain_808/", (float) 11.2, "Gran Premio de Espana", "Espanha", loops);
        gcirr.addCircuito(c);

        c = new Circuito();
        loops = new HashSet<Loop>();
        addLoop(loops, (float) 1.1, "mc_s1");
        addLoop(loops, (float) 2.2, "mc_s2");
        createCircuito(c, "Monte Carlo", (float) 3.3, "Circuito do MÃ³naco", 2, "http://www.formula1.com/races/in_detail/monaco_810/", (float) 5.0, "Circuito de Monte Carlo", "MÃ³naco", loops);
        gcirr.addCircuito(c);
    }

    public void createCircuito(Circuito c, String cid, float compKm, String desc, int gmt, String homeP, float larg, String nome, String pais, Set<Loop> loops){
        c.setCidade(cid);
        c.setComprimentoKm(compKm);
        c.setDescricao(desc);
        c.setGmt(gmt);
        c.setHomePage(homeP);
        c.setLarguraM(larg);
        c.setNome(nome);
        c.setPais(pais);
        c.setLoops(loops);
    }

    public void addLoop(Set<Loop> loops, float posicaoKm, String ref){
        Loop l = new Loop();
        l.setPosicaoKm(posicaoKm);
        l.setRef(ref);
        loops.add(l);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="initPilotos">
    public void initPilotos(){
        Equipa e = null;
        e = ger.getEquipa("Brawn-Mercedes");
        Transponder t = new Transponder();
        t.setRef("t1");
        Piloto p = new Piloto(1, "Jenson Button", new GregorianCalendar(1980, 0, 19).getTime(), "InglÃªs", 1, 7, 7, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Brawn-Mercedes");
        t = new Transponder();
        t.setRef("t2");
        p = new Piloto(2, "Rubens Barrichello", new GregorianCalendar(1972,5-1,23).getTime(), "Brasileiro", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("McLaren-Mercedes");
        t = new Transponder();
        t.setRef("t3");
        p = new Piloto(3, "Lewis Hamilton", new GregorianCalendar(1985,1-1,7).getTime(), "InglÃªs", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Renault");
        t = new Transponder();
        t.setRef("t4");
        p = new Piloto(4, "Fernando Alonso", new GregorianCalendar(1983,7-1,29).getTime(), "Espanhol", 1, 21, 17, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("STR-Ferrari");
        t = new Transponder();
        t.setRef("t5");
        p = new Piloto(5, "Sebastien Bourdais", new GregorianCalendar(1979,2-1,28).getTime(), "FrancÃªs", 7, 2, 0, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Force India-Mercedes");
        t = new Transponder();
        t.setRef("t6");
        p = new Piloto(6, "Adrian Sutil", new GregorianCalendar(1983,1-1,11).getTime(), "AlemÃ£o", 8, 1, 0, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Force India-Mercedes");
        t = new Transponder();
        t.setRef("t7");
        p = new Piloto(7, "Giancarlo Fisichella", new GregorianCalendar(1973,1-1,14).getTime(), "Italiano", 1, 3, 3, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Ferrari");
        t = new Transponder();
        t.setRef("t8");
        p = new Piloto(8, "Kimi Raikonnen", new GregorianCalendar(1979,10-1,17).getTime(), "FilandÃªs", 1, 17, 16, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Ferrari");
        t = new Transponder();
        t.setRef("t9");
        p = new Piloto(9, "Felipe Massa", new GregorianCalendar(1981,4-1,25).getTime(), "Brasileiro", 1, 11, 15, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Williams-Toyota");
        t = new Transponder();
        t.setRef("t10");
        p = new Piloto(10, "Nico Rosberg", new GregorianCalendar(1985,6-1,27).getTime(), "AlemÃ£o", 2, 1, 0, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("RBR-Renault");
        t = new Transponder();
        t.setRef("t11");
        p = new Piloto(11, "Mark Webber", new GregorianCalendar(1976,8-1,27).getTime(), "Australiano", 1, 1, 1, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Toyota");
        t = new Transponder();
        t.setRef("t12");
        p = new Piloto(12, "Jarno Trulli", new GregorianCalendar(1972,5-1,23).getTime(), "Italian", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Toyota");
        t = new Transponder();
        t.setRef("t13");
        p = new Piloto(13, "Timo Glock", new GregorianCalendar(1972,5-1,23).getTime(), "German", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("BMW Sauber");
        t = new Transponder();
        t.setRef("t14");
        p = new Piloto(14, "Nick Heidfeld", new GregorianCalendar(1972,5-1,23).getTime(), "German", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("BMW Sauber");
        t = new Transponder();
        t.setRef("t15");
        p = new Piloto(15, "Robert Kubica", new GregorianCalendar(1972,5-1,23).getTime(), "Polish", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Williams-Toyota");
        t = new Transponder();
        t.setRef("t16");
        p = new Piloto(16, "Kazuki Nakajima", new GregorianCalendar(1972,5-1,23).getTime(), "Japanese", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("RBR-Renault");
        t = new Transponder();
        t.setRef("t17");
        p = new Piloto(17, "Sebastian Vettel", new GregorianCalendar(1972,5-1,23).getTime(), "German", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("McLaren-Mercedes");
        t = new Transponder();
        t.setRef("t18");
        p = new Piloto(18, "Heikki Kovalainen", new GregorianCalendar(1972,5-1,23).getTime(), "Finnish", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("Renault");
        t = new Transponder();
        t.setRef("t19");
        p = new Piloto(19, "Nelsinho Piquet", new GregorianCalendar(1972,5-1,23).getTime(), "Brazilian", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);

        e = ger.getEquipa("STR-Ferrari");
        t = new Transponder();
        t.setRef("t20");
        p = new Piloto(20, "Sebastien Buemi", new GregorianCalendar(1972,5-1,23).getTime(), "Swiss", 1, 9, 13, "", t, e);
        gpr.addPiloto(p);


    }

    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="initUtilizadores">
    public void initUtilzadores(){

        gur.initCredenciais();


        HashSet<Credencial> hc;
        Utilizador ut;
        Equipa e;
        Credencial adm,gest,crono,sbtr,juiz;
        adm = new Admin();
        adm.setNome("Admin");
        sbtr = new SBTR();
        sbtr.setNome("SBTR");
        gest = new bl.psmJEEHibernate.entities.Gestor();
        gest.setNome("Gestor");
        crono = new bl.psmJEEHibernate.entities.Crono();
        crono.setNome("Crono");
        juiz = new bl.psmJEEHibernate.entities.Juiz();
        juiz.setNome("Juiz");






        ArrayList<Utilizador> lu = new ArrayList<Utilizador>();

        ////////
        //  GregorianCalendar (meses -> 0-11)
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "tiago", true, "tiagocorreia86@gmail.com" , "Tiago Correia", "tiago", 1986, 9, 13);
        hc.add(crono); hc.add(sbtr); hc.add(adm); hc.add(juiz); hc.add(gest);
        createEquipa(e,2001, "Brawn-Mercedes", "chassi1", "director1", 0, "motor1", 0, "peneus1", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "miguel", true, "miikeshi@gmail.com" , "Miguel Esteves", "miguel", 1985, 7, 8);
        hc.add(crono); hc.add(sbtr); hc.add(adm); hc.add(juiz); hc.add(gest);
        createEquipa(e,2002, "RBR-Renault", "chassi2", "director2", 0, "motor2", 0, "peneus2", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "ricardo", true, "rpsantosi@gmail.com" , "Ricardo Santos", "ricardo", 1984, 4, 14);
        hc.add(crono); hc.add(sbtr); hc.add(adm); hc.add(juiz); hc.add(gest);
        createEquipa(e,2003, "Toyota", "chassi3", "director3", 0, "motor3", 0, "peneus3", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "fernando", true, "fruas@gmail.com" , "Fernando Ruas", "fernando", 1971, 11, 25);
        hc.add(sbtr);
        createEquipa(e,2004, "Ferrari", "chassi4", "director4", 0, "motor4", 0, "peneus4", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "fabio", true, "fabio.lesi@gmail.com" , "Fabio Lima", "fabio", 1984, 10, 2);
        hc.add(juiz); hc.add(crono);
        createEquipa(e,2001, "Williams-Toyota", "chassi5", "director5", 0, "motor5", 0, "peneus5", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "nuno", true, "nunolesiacores@gmail.com" , "Nuno Correia", "nuno", 1985, 2, 6);
        hc.add(crono); hc.add(sbtr); hc.add(adm);
        createEquipa(e,2002, "McLaren-Mercedes", "chassi6", "director6", 0, "motor6", 0, "peneus6", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "vasco", true, "vascodebrito@hotmail.com" , "Vasco Oliveira", "vasco", 1986, 5, 6);

        createEquipa(e,2003, "Renault", "chassi7", "director7", 0, "motor7", 0, "peneus7", 0);
        mergeUtilizador(ut, hc, e);
        lu.add(ut);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "rui", true, "ruiveloso@gmail.com" , "Rui Veloso", "rui", 1985, 3, 20);
        hc.add(juiz);
        //createEquipa(e,2004, "equipa8", "chassi8", "director8", 0, "motor8", 0, "peneus8", 0);
        //mergeUtilizador(ut, hc, e);
        ut.setCredenciais(hc);
        lu.add(ut);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "bmw", true, "bmw@gmail.com" , "John Doe BMW", "bmw", 1980, 1, 20);
        hc.add(juiz);
        createEquipa(e,2005, "BMW Sauber", "chassi8", "director8", 0, "motor8", 0, "peneus8", 0);
        mergeUtilizador(ut, hc, e);
        ut.setCredenciais(hc);
        lu.add(ut);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "str", true, "str@gmail.com" , "John Doe STR", "str", 1980, 1, 20);
        hc.add(juiz);
        createEquipa(e,2006, "STR-Ferrari", "chassi9", "director9", 0, "motor9", 0, "peneus9", 0);
        mergeUtilizador(ut, hc, e);
        ut.setCredenciais(hc);
        lu.add(ut);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
        createUtilizador(ut, "force", true, "force@gmail.com" , "John Doe Force", "force", 1980, 1, 20);
        hc.add(juiz);
        createEquipa(e,2007, "Force India-Mercedes", "chassi10", "director10", 0, "motor10", 0, "peneus10", 0);
        mergeUtilizador(ut, hc, e);
        ut.setCredenciais(hc);
        lu.add(ut);



        for(int i=1;i<50;i++) {
            ///////////////////////////////////////////////////////////////////////////////////////////////////
            ut = new Utilizador(); hc = new HashSet<Credencial>(); e = new Equipa();
            createUtilizador(ut, "guest"+i, true, "user"+i+"@gmail.com" , "John Doe", "guest"+i, 1960+i, 6, 6);
            hc.add(sbtr);
            lu.add(ut);
        }


        gur.setUtilizadores(lu);

    }


    public void createUtilizador(Utilizador ut, String user,boolean activo,String email,String nome,String pass,int y,int m,int d){
        ut.setUser(user);
        ut.setActivo(activo);
        ut.setEstado("offline");
        ut.setEmail(email);
        ut.setNome(nome);
        ut.setPass(pass);

        ut.setDataNascimento(new GregorianCalendar(y,m,d).getTime());
    }

    public void createEquipa(Equipa e, int anoentrada, String nome,String chassi,String director,int mposicao,String motor,int numvezesmp,String peneus,int pole){
        e.setAnoEntrada(anoentrada);
        e.setNome(nome);
        e.setChassi(chassi);
        e.setDirector(director);
        e.setMelhorPosicao(mposicao);
        e.setMotor(motor);
        e.setNumeroVezesMP(numvezesmp);
        e.setPneus(peneus);
        e.setPolepositions(pole);

    }

    public void mergeUtilizador(Utilizador ut,HashSet<Credencial> hc, Equipa e){
        ut.setCredenciais(hc);
        ut.setEquipa(e);
        e.setUtilizador(ut);
    }

    // </editor-fold>

    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }
}