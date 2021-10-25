package com.example.demo.system.networkassetlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.system.networkassetlist.nms.domain.NmsNetworkList;
import com.example.demo.system.networkassetlist.nms.repository.NmsNetworkListRepository;

@Service
@Transactional
public class IfrNetworkListService {


	@Autowired
	private IfrNetworkListSave ifrNetworkListSave;

	@Autowired
	private NmsNetworkListRepository nmsNetworkListRepository;


	public void processIfrMember() {

//		List<NmsNetworkList> li = nmsNetworkListRepository.findAll();
		List<NmsNetworkList> li = nmsNetworkListRepository.fetchByBatchFlag("N");

		for(NmsNetworkList i : li) {
			
			System.out.println(i.getId());
			System.out.println(i.getName());
						

			try {
				ifrNetworkListSave.oneSave(i);
			}catch(Exception e) {
			}
		}

	}
}
