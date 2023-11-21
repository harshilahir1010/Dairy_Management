package com.demo.dairy.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.dairy.entity.ImageData;
import com.demo.dairy.repo.ImageDataRepo;
import com.demo.dairy.util.ImageUtil;


@Service
public class ImageDataService {

	@Autowired
	private ImageDataRepo repo;

	public String uploadImage(MultipartFile multipartFile) throws IOException {

		ImageData imageData = repo
				.save(ImageData.builder().name(multipartFile.getOriginalFilename()).type(multipartFile.getContentType())
						.imageData(ImageUtil.compressImage(multipartFile.getBytes())).build());

		if (imageData != null) {
			return "File Uploaded sucessfully" + multipartFile.getOriginalFilename();
		}
		return null;
	}

	public byte[] downloadImage(String name) {

		Optional<ImageData> dbImageData = repo.findByName(name);
		byte[] image = ImageUtil.decompressImage(dbImageData.get().getImageData());
		return image;
	}
	

	public List<ImageData> allIma() {
		return repo.findAll();
	}

}
