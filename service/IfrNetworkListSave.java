package com.example.demo.system.networkassetlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.system.networkassetlist.infra.domain.IfrNetworkList;
import com.example.demo.system.networkassetlist.infra.repository.IfrNetworkListRepository;
import com.example.demo.system.networkassetlist.nms.domain.NmsNetworkList;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,noRollbackFor = Exception.class)

public class IfrNetworkListSave {
	
	@Autowired
	private IfrNetworkListRepository ifrNetworkListRepository;

	public void oneSave(NmsNetworkList i) {
		
		IfrNetworkList ifrNetworkList = new IfrNetworkList();
		
		try {
			
			System.out.println("oneSave");
			
			ifrNetworkList.setName(i.getName());
			ifrNetworkList.setId(i.getId());
			ifrNetworkListRepository.save(ifrNetworkList);
		}catch (Exception e) {

			System.out.println("Error");
			System.out.println(e.toString());
			
		}
	}



}
