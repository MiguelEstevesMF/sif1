package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Transponder")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)


public class Transponder implements Serializable {

	@Column(name="Ref", nullable=true, length=255, unique=true)	
	private String ref;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@OneToOne(mappedBy="transponder", targetEntity=bl.psmJEEHibernate.entities.Piloto.class,fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	private Piloto piloto;
	
	public void setRef(String value) {
		this.ref = value;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	
	public void setPiloto(Piloto value) {
		this.piloto = value;
	}
	
	public Piloto getPiloto() {
		return piloto;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transponder other = (Transponder) obj;
        if ((this.ref == null) ? (other.ref != null) : !this.ref.equals(other.ref)) {
            return false;
        }
        if (this.ID != other.ID) {
            return false;
        }
        
        return true;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ID;
        return hash;
    }


	
}
