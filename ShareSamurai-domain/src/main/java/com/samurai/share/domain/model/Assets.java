package com.samurai.share.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Assets implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String assetsId;

	private boolean assetsName;

	private Date createdAt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}

	public boolean isAssetsName() {
		return assetsName;
	}

	public void setAssetsName(boolean assetsName) {
		this.assetsName = assetsName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
