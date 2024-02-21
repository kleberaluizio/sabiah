package com.jasperpoc.demo.entities;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Disease
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	private String description;

	@ElementCollection
	private Set<String> recommendations;
	@ElementCollection
	private Set<String> videosLinks;

	public boolean addRecommendation(String recommendation){
		return this.recommendations.add(recommendation);
	}

	public boolean addVideoLink(String videoLink){
		return this.videosLinks.add(videoLink);
	}

}
