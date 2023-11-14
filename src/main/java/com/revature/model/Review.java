package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="revid")
	int revid;
	@Column(name="userid")
	int userid;
	@Column(name="movieid")
	String movieid;
	@Column(name="revrating")
	double revrating;
	@Column(name="revdesc")
	String revdesc;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int revid, int userid, String movieid, double revrating, String revdesc) {
		super();
		this.revid = revid;
		this.userid = userid;
		this.movieid = movieid;
		this.revrating = revrating;
		this.revdesc = revdesc;
	}

	public int getRevid() {
		return revid;
	}

	public void setRevid(int revid) {
		this.revid = revid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public double getRevrating() {
		return revrating;
	}

	public void setRevrating(double revrating) {
		this.revrating = revrating;
	}

	public String getRevdesc() {
		return revdesc;
	}

	public void setRevdesc(String revdesc) {
		this.revdesc = revdesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieid == null) ? 0 : movieid.hashCode());
		result = prime * result + ((revdesc == null) ? 0 : revdesc.hashCode());
		result = prime * result + revid;
		long temp;
		temp = Double.doubleToLongBits(revrating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (movieid == null) {
			if (other.movieid != null)
				return false;
		} else if (!movieid.equals(other.movieid))
			return false;
		if (revdesc == null) {
			if (other.revdesc != null)
				return false;
		} else if (!revdesc.equals(other.revdesc))
			return false;
		if (revid != other.revid)
			return false;
		if (Double.doubleToLongBits(revrating) != Double.doubleToLongBits(other.revrating))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [revid=" + revid + ", userid=" + userid + ", movieid=" + movieid + ", revrating=" + revrating
				+ ", revdesc=" + revdesc + "]";
	}

	
	
	

}
