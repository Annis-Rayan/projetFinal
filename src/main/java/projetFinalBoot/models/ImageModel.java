package projetFinalBoot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import projetFinalBoot.entity.views.Views;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="image_model")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ImageModel {
	
	@JsonView(Views.Common.class)
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    
	@JsonView(Views.Common.class)
    @Column(name = "name")
    private String name;

	@JsonView(Views.Common.class)
    @Column(name = "type")
    private String type;

	@JsonView(Views.Common.class)
    @Lob
    @Column(name = "pic")
    private byte[] pic;

//Custom Construtor
    public ImageModel(String name, String type, byte[] pic) {
        this.name = name;
        this.type = type;
        this.pic = pic;
    }

	public ImageModel() {
	super();
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
    
    
    
}
