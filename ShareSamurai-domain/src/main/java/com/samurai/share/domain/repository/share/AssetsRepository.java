package com.samurai.share.domain.repository.share;

import java.util.Collection;
import java.util.Optional;

import com.samurai.share.domain.model.Assets;

public interface AssetsRepository {

	Optional<Assets> findById(String assetsId);

	Collection<Assets> findAll();

	void create(Assets assets);

	boolean update(Assets assets);

	void delete(Assets assets);

}
