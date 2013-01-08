package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Crono")


public class Crono extends Credencial implements Serializable {

	
}
