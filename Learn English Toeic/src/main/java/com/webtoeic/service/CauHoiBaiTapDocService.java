package com.webtoeic.service;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.webtoeic.entities.CauHoiBaiTapDoc;
import com.webtoeic.repository.CauHoiBaiTapDocRepository;

@Service
public class CauHoiBaiTapDocService {
	@Autowired
	private CauHoiBaiTapDocRepository cauHoiRepo;
	
	public Page<CauHoiBaiTapDoc> findListCauHoiByBaiTapId(int page, int size, long baiTapDocId) {
		return cauHoiRepo.findByBaiTapDocId(baiTapDocId, PageRequest.of(page - 1, size));
	}
	
	public Optional<CauHoiBaiTapDoc> findCauHoiById(long id) {
		return cauHoiRepo.findById(id);
	}
	
	@Transactional
	public CauHoiBaiTapDoc saveCauHoiBaiTapDoc(CauHoiBaiTapDoc cauHoiBaiTapDoc, HttpServletRequest request)
			throws IOException {
		return cauHoiRepo.save(cauHoiBaiTapDoc);
	}
	
	public void deleteCauHoiBaiTapDoc(long id) {
		cauHoiRepo.deleteById(id);
	}

}
