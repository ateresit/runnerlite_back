package ru.runnerlite.entities.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDto implements Serializable {
	private Integer id;
	private String name;
	private String phoneNumber;
	private String relativeType;
	private SecUserDto secUsers;
	private Boolean mainContact;
}
