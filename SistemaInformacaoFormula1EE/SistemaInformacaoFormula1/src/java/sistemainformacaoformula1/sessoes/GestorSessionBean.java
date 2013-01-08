/*
 * GestorSessionBean.java
 *
 * Created on 26/Jun/2009, 16:29:12
 * Copyright Miguel
 */

package sistemainformacaoformula1.sessoes;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Treino;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class GestorSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    private ArrayList<TreinoRow> listaTreinos = new ArrayList<TreinoRow>();
    private ArrayList<LoopRow> listaLoops = new ArrayList<LoopRow>();
    private ArrayList<String> listaPilotos = new ArrayList<String>();


    public ArrayList<String> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ArrayList<String> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public ArrayList<LoopRow> getListaLoops() {
        return listaLoops;
    }

    public void setListaLoops(ArrayList<LoopRow> listaLoops) {
        this.listaLoops = listaLoops;
    }

    public ArrayList<TreinoRow> getListaTreinos() {
        return listaTreinos;
    }

    public void setListaTreinos(ArrayList<TreinoRow> listaTreinos) {
        this.listaTreinos = listaTreinos;
    }



    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public GestorSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("ListaUtilizadoresSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }





   /* public void addListaTreinos(Date d){
        TreinoRow t = new TreinoRow((this.listaTreinos.size()+1)+"", d);
        listaTreinos.add(t);
    }*/

    public void addListaTreinos(Treino t){
        if(t.getData()==null) t.setData(new GregorianCalendar().getTime());
        TreinoRow tr = new TreinoRow((this.listaTreinos.size()+1)+"", t);
        listaTreinos.add(tr);
    }

    public void removeTreino(){
        if(getSelectedT()==-1) return;
        this.listaTreinos.remove(getSelectedT());
        for(int i=0;i<this.listaTreinos.size();i++)
            this.listaTreinos.set(i,new TreinoRow((i+1)+"",this.listaTreinos.get(i).getData()));
    }

    public void setSelectedT(int j){
        for(int i=0;i<this.listaTreinos.size();i++){
            if(i==j)
                this.listaTreinos.get(i).setSelected(true);
            else
                this.listaTreinos.get(i).setSelected(false);
        }
    }

    public int getSelectedT(){
        for(int i=0;i<this.listaTreinos.size();i++)
            if(this.listaTreinos.get(i).getSelected()) return i;
        return -1;
    }


    public void addListaLoops(Loop l){
        LoopRow t = new LoopRow(l);
        listaLoops.add(t);
    }

    public void addListaLoops(String desc, float pos){
        LoopRow t = new LoopRow(desc,pos);
        listaLoops.add(t);
    }

    public void removeLoop(){
        if(getSelectedL()==-1) return;
        if (this.listaLoops.get(getSelectedL()).getDescricao().equals("fl") || this.listaLoops.get(getSelectedL()).getDescricao().equals("box")) return;
        this.listaLoops.remove(getSelectedL());
        for(int i=0;i<this.listaLoops.size();i++)
            this.listaLoops.set(i,new LoopRow(this.listaLoops.get(i).getDescricao(),this.listaLoops.get(i).getPosicao()));
    }

    public void setSelectedL(int j){
        for(int i=0;i<this.listaLoops.size();i++){
            if(i==j)
                this.listaLoops.get(i).setSelected(true);
            else
                this.listaLoops.get(i).setSelected(false);
        }
    }

    public int getSelectedL(){
        for(int i=0;i<this.listaLoops.size();i++)
            if(this.listaLoops.get(i).getSelected()) return i;
        return -1;
    }


}