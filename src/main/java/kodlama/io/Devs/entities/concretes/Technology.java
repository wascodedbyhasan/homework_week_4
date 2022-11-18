package kodlama.io.Devs.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TechnologyId")
	private int id;
	
	@Column(name = "TechnologyName")
	private String name;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "LanguageId", nullable = false)
	private Language language;
}
