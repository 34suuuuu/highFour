package com.highFour.Hand2Hand.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.highFour.Hand2Hand.common.dto.PresignedReqDto;
import com.highFour.Hand2Hand.common.service.FileService;

@RequiredArgsConstructor
@RestController
public class ImageUploadController {
	private final FileService fileService;

	@PostMapping("/api/upload/presigned-url")
	public String getPresignedUrl(@RequestBody PresignedReqDto presignedReqDto) {
		return fileService.getPreSignedUrl(presignedReqDto.prefix(), presignedReqDto.url());
	}
}