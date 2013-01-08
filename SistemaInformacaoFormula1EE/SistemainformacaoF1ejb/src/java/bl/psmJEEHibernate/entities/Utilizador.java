package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="Utilizador")


public class Utilizador implements Serializable {

   @Column(name="Nome", nullable=false)
   private String nome;

   @Column(name="DataNasc", nullable=false)
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dataNascimento;

   @Column(name="Email", nullable=false,unique=true)
   private String email;
	
	@Column(name="Username", nullable=false)
	@Id	
	private String user;
	
	@Column(name="Pass", nullable=true, length=255)	
	private String pass;
	
	@Column(name="Activo", nullable=false, length=1)	
	private boolean activo;

    @Column(name="Estado", nullable=false)
	private String estado;

	@ManyToMany(targetEntity=bl.psmJEEHibernate.entities.Credencial.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	@JoinTable(name="Utilizador_Credencial", joinColumns={ @JoinColumn(name="UtilizadorLogin") }, inverseJoinColumns={ @JoinColumn(name="CredencialNome") })
	private Set<Credencial> credenciais = new HashSet<Credencial>();

    @OneToOne(targetEntity=bl.psmJEEHibernate.entities.Equipa.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE,optional=true)
    @JoinColumn(name="Equipa",referencedColumnName="ID")
    private Equipa equipa;

    
	public void setUser(String value) {
		this.user = value;
	}
	
	public String getUser() {
		return user;
	}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
	
	public void setPass(String value) {
		this.pass = value;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setActivo(boolean value) {
		this.activo = value;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setCredenciais(Set<Credencial> value) {
		this.credenciais = value;
	}
	
	public Set<Credencial> getCredenciais() {
		return credenciais;
	}


   public Date getDataNascimento() {
        return dataNascimento;
    }

  
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
   public String getNome() {
      return nome;
   }

   
   public void setNome(String nome) {
      this.nome = nome;
   }


    public Equipa getEquipa() {
        return equipa;
    }


    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }


	
	
}
