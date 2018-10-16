package com.example.androidacademy.utils;

public class SocialUrl {

    private SocialUrl(){}

    public final static String FACEBOOK = wrapHttpsUrl("facebook.com");
    public final static String GITHUB = wrapHttpsUrl("github.com");
    public final static String VK = wrapHttpsUrl("vk.com");

    private static String wrapHttpsUrl(final String url) {
        return "https://".concat(url);
    }

}
