package me.xhw.exception;

import org.springframework.security.oauth2.common.exceptions.ClientAuthenticationException;

public class ReLoginException extends ClientAuthenticationException {

    public ReLoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public ReLoginException(String msg) {
        super(msg);
    }

    @Override
    public int getHttpErrorCode() {
        return 506;
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_token";
    }
}
