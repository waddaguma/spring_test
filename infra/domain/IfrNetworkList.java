package com.example.demo.system.networkassetlist.infra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
@Table(name="ifr_network_list")
public class IfrNetworkList {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="username")
    private String name;
 
}
