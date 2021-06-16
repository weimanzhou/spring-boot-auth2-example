package com.yuki.springbootauthentication.model.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class OauthClientDetails {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid.hex")
    @GeneratedValue(generator = "uuid")
    private String id;

    private String resourceIds,
            scope,
            authorizedGrantTypes,
            webServerRedirectUri,
            authorities,
            accessTokenValidity,
            refreshTokenValidity,
            additionalInformation,
            autoapprove,
            clientSecret,
            clientId;

}
