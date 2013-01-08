package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Loop1")

public class Loop implements Serializable {
	
	@Column(name="Ref1", nullable=true, length=255)
	private String ref;
	
	@Column(name="PosicaoKm", nullable=false)	
	private float posicaoKm;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
    
	public void setRef(String value) {
		this.ref = value;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setPosicaoKm(float value) {
		this.posicaoKm = value;
	}
	
	public float getPosicaoKm() {
		return posicaoKm;
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loop other = (Loop) obj;
        if ((this.ref == null) ? (other.ref != null) : !this.ref.equals(other.ref)) {
            return false;
        }
        if (this.posicaoKm != other.posicaoKm) {
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
        hash = 13 * hash + this.ID;
        return hash;
    }
	

	
}
