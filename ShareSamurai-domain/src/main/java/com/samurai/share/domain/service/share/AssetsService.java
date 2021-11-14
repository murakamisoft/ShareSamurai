package com.samurai.share.domain.service.share;

import java.util.Collection;

import com.samurai.share.domain.model.Assets;

public interface AssetsService {
	Collection<Assets> findAll();

	Assets create(Assets assets);

	void delete(String assetsId);
}
