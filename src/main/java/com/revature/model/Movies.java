package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="movies")
public class Movies {
	@Column(name="title")
    @JsonProperty("Title")
    String title;
	@Column(name="relyear")
    @JsonProperty("Year")
    String year;
	@Column(name="poster")
    @JsonProperty("Poster")
    String poster;
    @Id
	@Column(name="imdbID")
    @JsonProperty("imdbID")
    String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movies() {
    }

    public Movies(String title, String year, String poster, String id) {
        this.title = title;
        this.year = year;
        this.poster = poster;

        this.id = id;
    }
}
