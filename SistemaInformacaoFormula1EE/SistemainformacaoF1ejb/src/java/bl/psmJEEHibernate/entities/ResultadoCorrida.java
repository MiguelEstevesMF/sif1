package bl.psmJEEHibernate.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@DiscriminatorValue("ResultadoCorrida")


public class ResultadoCorrida extends ResultadoPiloto implements Serializable {

	
	@Column(name="Pontos", nullable=true, length=11)	
	private int pontos;
	
	@Column(name="PosicaoGrelha", nullable=true, length=11)	
	private int posicaoGrelha;
	
	@Column(name="TempoMelhorVolta", nullable=true)	
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private long tempoMelhorVolta;
	
	@Column(name="VoltaMelhorTempo", nullable=true, length=11)	
	private int voltaMelhorTempo;
	
	@Column(name="VelocidadeMedia", nullable=true)	
	private float velocidadeMedia;
	
	public void setPontos(int value) {
		this.pontos = value;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPosicaoGrelha(int value) {
		this.posicaoGrelha = value;
	}
	
	public int getPosicaoGrelha() {
		return posicaoGrelha;
	}
	
	public void setTempoMelhorVolta(long value) {
		this.tempoMelhorVolta = value;
	}
	
	public long getTempoMelhorVolta() {
		return tempoMelhorVolta;
	}
	
	public void setVoltaMelhorTempo(int value) {
		this.voltaMelhorTempo = value;
	}
	
	public int getVoltaMelhorTempo() {
		return voltaMelhorTempo;
	}
	
	public void setVelocidadeMedia(float value) {
		this.velocidadeMedia = value;
	}
	
	public float getVelocidadeMedia() {
		return velocidadeMedia;
	}

}
