package com.example.demo.system.networkassetlist.nms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="network_list")
public class NmsNetworkList {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="username")
    private String name;

    private String batch_flag;

}
