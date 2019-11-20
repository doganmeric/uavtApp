package uavtApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="locations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
	@Id
	@Column(name="location_id")
	private String locationId;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state_province")
	private String stateProvince;
	
	@Column(name="country_id")
	private String countryId;
}
