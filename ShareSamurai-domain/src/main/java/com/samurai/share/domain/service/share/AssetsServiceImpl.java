package com.samurai.share.domain.service.share;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.samurai.share.domain.model.Assets;
import com.samurai.share.domain.repository.share.AssetsRepository;

@Service
@Transactional
public class AssetsServiceImpl implements AssetsService {

	@Inject
	AssetsRepository assetsRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Assets> findAll() {
		return assetsRepository.findAll();
	}

	@Override
	public Assets create(Assets assets) {
		String userId = UUID.randomUUID().toString();
		String assetsId = UUID.randomUUID().toString();
		Date createdAt = new Date();

		assets.setUserId(userId);
		assets.setAssetsId(assetsId);
		assets.setAssetsName(assets.getAssetsName());
		assets.setCreatedAt(createdAt);

		assetsRepository.create(assets);

		return assets;
	}

	@Override
	public void delete(String assetsId) {
		Assets assets = findOne(assetsId);
		assetsRepository.delete(assets);
	}

	private Assets findOne(String assetsId) {
		return assetsRepository.findById(assetsId).orElseThrow(() -> {
			ResultMessages messages = ResultMessages.error();
			messages.add(ResultMessage.fromText("[E404] The requested Assets is not found. (id=" + assetsId + ")"));
			return new ResourceNotFoundException(messages);
		});
	}

}
