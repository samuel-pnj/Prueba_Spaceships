package com.example.spaceships.model.Spaceship;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Spaceship {

	@Id
    private Long id;
    private String name;
    private String series;
    
    public Spaceship() {
    }
    
    public Spaceship(Long id, String name, String series) {
        this.id = id;
        this.name = name;
        this.series = series;
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
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	
	 @Override
	    public String toString() {
	        return "Spaceship{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", series='" + series + '\'' +
	                '}';
	    }
}
