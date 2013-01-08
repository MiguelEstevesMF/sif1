package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Circuito;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GerirCircuitoLocal {

    public List<Circuito> getCircuitos();

    public Circuito getCircuito(String nome);

    public void addCircuito(Circuito c);

    public void remCircuito(Circuito c);

    public void editCircuito(Circuito c);

    public void save(java.lang.Object o);

    public void remove(java.lang.Object o);

    public java.util.ArrayList<bl.psmJEEHibernate.entities.Circuito> findAllOrdenado(java.lang.String campo, java.lang.String ordem, int limit, int offset);

    public int countCircuitos();

    public byte[] getImagem(bl.psmJEEHibernate.entities.Circuito c);
    
}
