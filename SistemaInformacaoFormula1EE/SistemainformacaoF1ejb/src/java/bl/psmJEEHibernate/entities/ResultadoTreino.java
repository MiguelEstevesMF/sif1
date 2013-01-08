package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity
@DiscriminatorValue("ResultadoTreino")


public class ResultadoTreino extends ResultadoPiloto implements Serializable {

	
}
