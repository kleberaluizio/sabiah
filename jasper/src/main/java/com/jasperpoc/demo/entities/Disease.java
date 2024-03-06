package com.jasperpoc.demo.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "disease_table")
public class Disease
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	private String recommendations;
	@Column(name = "videos_links")
	private String videosLinks ;

}
