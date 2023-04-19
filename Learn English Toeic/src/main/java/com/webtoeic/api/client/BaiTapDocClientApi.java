package com.webtoeic.api.client;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtoeic.entities.BaiTapDoc;
import com.webtoeic.entities.CauHoiBaiTapDoc;
import com.webtoeic.service.BaiTapDocService;
import com.webtoeic.service.CauHoiBaiTapDocService;

@RestController
@RequestMapping("api/client/bai-doc")
public class BaiTapDocClientApi {

	@Autowired
	private BaiTapDocService baiTapDocService;

	@Autowired
	private CauHoiBaiTapDocService cauHoiBaiTapDocService;

	@GetMapping("/baiDocId={baiDocId}")
	public ResponseEntity<Page<CauHoiBaiTapDoc>> getListCauHoiByBaiTapDocId(@PathVariable("baiDocId") long id,
			@RequestParam(defaultValue = "1") int page) {

		return new ResponseEntity<>(cauHoiBaiTapDocService.findListCauHoiByBaiTapId(page, 10, id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Page<BaiTapDoc>> getAllByPartToeic(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = true) int part, @RequestParam(required = true) int doKho) {

		return new ResponseEntity<>(baiTapDocService.findAllListBaiTapDocByPartAndDoKho(page, 10, part, doKho),
				HttpStatus.OK);

	}
}
