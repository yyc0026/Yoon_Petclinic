package dev.spring.petclinic.owner.model;

import dev.spring.petclinic.pet.controller.dto.PetRes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Owner {

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;
	private List<PetRes> pets;  // pets 필드 추가

	// 다른 필드와 메서드

	// Owner 객체를 업데이트할 때 사용되는 메서드
	public Owner updateWith(Owner newOwnerData) {
		this.firstName = newOwnerData.getFirstName();
		this.lastName = newOwnerData.getLastName();
		this.address = newOwnerData.getAddress();
		this.city = newOwnerData.getCity();
		this.telephone = newOwnerData.getTelephone();
		return this;
	}
}
