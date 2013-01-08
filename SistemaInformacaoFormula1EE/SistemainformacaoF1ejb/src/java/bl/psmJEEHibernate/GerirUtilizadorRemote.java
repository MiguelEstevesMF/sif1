package bl.psmJEEHibernate;


import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Utilizador;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface GerirUtilizadorRemote {

    public void create(Utilizador u);

    public void edit(Utilizador u);

    public void remove(Utilizador utilizador);

    public HashSet<Credencial> getCredenciaisUtilizador(String user);

    public HashSet<Credencial> findAllCredenciais();

    public Utilizador getUtilizador(String user) throws Exception;

    public ArrayList<Utilizador> getUtilizadores();

    public void setUtilizador(Utilizador u);

    public void setUtilizadores(ArrayList<Utilizador> us);

    public Utilizador loginValido(String user, String pass) throws Exception;

    public ArrayList<Utilizador> findAllOrdenado(String campo, String ordem, int limit, int offset);

    public void initCredenciais();

    public boolean hasUser(String username);

    public boolean hasEmail(String email);

    public int countUtilizadores();

    public Equipa getEquipa (String user);
}