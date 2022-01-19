package com.authentication.session.controller.constant;

public enum MemberStatus {

    ACTIVE_MEMBER(1),
    INACTIVE_MEMBER(2),
    DELETED_MEMBER(3)
    ;

    private final int code;

    MemberStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
