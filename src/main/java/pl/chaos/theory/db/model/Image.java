package pl.chaos.theory.db.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
/**
 * DB Model of image.
 */
public class Image extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Lob
        @Column(name = "image", columnDefinition = "mediumblob")
	private byte[] imageBytes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
}
