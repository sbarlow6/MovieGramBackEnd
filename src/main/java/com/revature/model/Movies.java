package com.revature.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    @Column(name="reldate")
    @JsonProperty("Released")
    String reldate;
    @Column(name="plot")
    @JsonProperty("Plot")
    String plot;
    
    @Column(name = "RTscore")
    private String RTscore;

    @Transient
    @JsonProperty("Ratings")
	public List<Rating> ratings;

    public static class Rating {
        @JsonProperty("Source")
        private String source;

        @JsonProperty("Value")
        private String value;

        public String getValue() {
            return value;
        }

		public String getSource() {
			return source;
		}
    }
    

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
    public String getReldate() {
        return reldate;
    }

    public void setReldate(String reldate) {
        this.reldate = reldate;
    }
    public String getplot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
    public String getRTscore() {
        return RTscore;
    }

    public void setRTscore(String RTscore) {
    	
        this.RTscore = RTscore;
    }
    public List<Rating> getratings() {
        return ratings;
    }

    public Movies() {
    	this.RTscore = "N/A";
    }

    public Movies(String title, String year, String poster, String id, String reldate, String plot, String RTscore) {
    	
        this.title = title;
        this.year = year;
        this.poster = poster;
        this.id = id;
        this.reldate = reldate;
        this.plot = plot;
        this.RTscore = RTscore;
    }
}
