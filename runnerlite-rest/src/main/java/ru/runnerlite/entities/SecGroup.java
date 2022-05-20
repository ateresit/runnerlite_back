package ru.runnerlite.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sec_groups")
public class SecGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "ACTIVE", nullable = false)
	private Boolean active = false;
	
	@Column(name = "DESCRIPTION", length = 512)
	private String description;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public String getDescription() {
		return description;
	}
	
}