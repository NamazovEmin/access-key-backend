package com.example.accesskeybackend.template.service;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.InetAddressValidator;

import org.springframework.stereotype.Service;

@Service
public class IPVersionService {

    public boolean checkIpv6SupportV1(String siteUrl) {
        try {
            String address;
            if (siteUrl.contains(":")) {
                URI uri = new URI(siteUrl);
                String host = uri.getHost();
                address = InetAddress.getByName(host).getHostAddress();
            } else {
                address = InetAddress.getByName(siteUrl).getHostAddress();
            }
            return Pattern.compile("^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$")
                    .matcher(address)
                    .find();
        } catch (URISyntaxException | UnknownHostException e) {
            throw new IllegalArgumentException("Cant' check for IPv6 support this url: " + siteUrl);
        }
    }

    public boolean checkIpv6SupportV2(String siteUrl) {
        try {
            String address;
            if (siteUrl.contains(":")) {
                URI uri = new URI(siteUrl);
                String host = uri.getHost();
                address = InetAddress.getByName(host).getHostAddress();
            } else {
                address = InetAddress.getByName(siteUrl).getHostAddress();
            }
            return InetAddressValidator.getInstance().isValidInet6Address(address);
        } catch (URISyntaxException | UnknownHostException e) {
            throw new IllegalArgumentException("Cant' check for IPv6 support this url: " + siteUrl);
        }
    }
}
