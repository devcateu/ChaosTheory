package pl.chaos.theory.db.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "algorithm")
public class Algorithm extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@OneToMany(mappedBy = "algorithmId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ParameterInfo> parameterInfoSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ParameterInfo> getParameterInfoSet() {
		return parameterInfoSet;
	}

	public void setParameterInfoSet(Set<ParameterInfo> parameterInfoSet) {
		this.parameterInfoSet = parameterInfoSet;
	}
}
