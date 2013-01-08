package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Juiz")


public class Juiz extends Credencial implements Serializable {

	
}
