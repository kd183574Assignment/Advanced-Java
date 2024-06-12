package com.sunbeam.beans;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	
	private int id;
	private int cnt = 0;
	private int voteStatus;
	private int userStatus;
	private int userId;
	
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}

	public VoteBean(int id, int cnt, int voteStatus, int userStatus, int userId) {
		super();
		this.id = id;
		this.cnt = cnt;
		this.voteStatus = voteStatus;
		this.userStatus = userStatus;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getVoteStatus() {
		return voteStatus;
	}

	public void setVoteStatus(int voteStatus) {
		this.voteStatus = voteStatus;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public void vote()
	{
		try {
			CandidateDao cd = new CandidateDaoImpl();
			this.cnt = cd.incrementVote(this.id);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getStatusOfVoting()
	{
		try {
			UserDao userDao = new UserDaoImpl();
			User user = userDao.findById(this.userId);
			
			if(user.getStatus() == 0) {
				this.voteStatus=1;
				
			}else {
				this.voteStatus=0;
			}
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.getStackTrace();
		}
	}
	
	public void setStatusUser() {
		try {
			UserDao userDao = new UserDaoImpl();
			userDao.updateStatus(this.userId, true);
		}
		catch(Exception e1){
			e1.printStackTrace();
			
		}
	}
}
