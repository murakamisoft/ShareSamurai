package com.samurai.share.app.share;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.github.dozermapper.core.Mapper;
import com.samurai.share.app.share.AssetsForm.AssetsCreate;
import com.samurai.share.app.share.AssetsForm.AssetsDelete;
import com.samurai.share.domain.model.Assets;
import com.samurai.share.domain.service.share.AssetsService;

@Controller
@RequestMapping("assets")
public class AssetsController {
	@Inject
	AssetsService assetsService;

	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public AssetsForm setUpForm() {
		AssetsForm form = new AssetsForm();
		return form;
	}

	@GetMapping("list")
	public String list(Model model) {
		Collection<Assets> assetses = assetsService.findAll();
		model.addAttribute("assetses", assetses);
		return "assets/list";
	}

	@PostMapping("create")
	public String create(@Validated({ Default.class, AssetsCreate.class }) AssetsForm assetsForm,
			BindingResult bindingResult, Model model, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return list(model);
		}

		Assets assets = beanMapper.map(assetsForm, Assets.class);

		try {
			assetsService.create(assets);
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return list(model);
		}

		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Created successfully!")));
		return "redirect:/assets/list";
	}

	@PostMapping("delete")
	public String delete(@Validated({ Default.class, AssetsDelete.class }) AssetsForm form, BindingResult bindingResult,
			Model model, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return list(model);
		}

		try {
			assetsService.delete(form.getAssetsId());
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return list(model);
		}

		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Deleted successfully!")));
		return "redirect:/assets/list";
	}

}