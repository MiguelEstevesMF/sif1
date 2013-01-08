package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Credencial")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Credencial")

public class Credencial implements Serializable {
	
	@Column(name="Nome", nullable=false )
	@Id	
	private String nome;
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}

	
	
}
