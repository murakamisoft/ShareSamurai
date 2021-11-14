package com.samurai.share.app.share;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AssetsForm implements Serializable {
	public static interface AssetsCreate {
	};

	public static interface AssetsFinish {
	};

	public static interface AssetsDelete {
	}

	private static final long serialVersionUID = 1L;

	@NotNull(groups = { AssetsFinish.class, AssetsDelete.class })
	private String assetsId;

	@NotNull(groups = { AssetsCreate.class })
	@Size(min = 1, max = 30, groups = { AssetsCreate.class })
	private String assetsName;

	public String getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

}
