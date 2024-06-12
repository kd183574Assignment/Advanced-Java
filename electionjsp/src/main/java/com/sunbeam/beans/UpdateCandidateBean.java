package com.sunbeam.beans;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String name;
	private String party;
	private int vote;
	private int count;
	
	public UpdateCandidateBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
	public void updateCandidate() {
		Candidate c = new Candidate(id, name, party, vote);
		
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			count = candDao.update(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
}
