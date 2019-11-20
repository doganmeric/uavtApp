package uavtApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="regions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Region {
	
	@Id
	@Column(name="region_id")
	private String regionId;
	
	@Column(name="region_name")
	private String regionName;

}
