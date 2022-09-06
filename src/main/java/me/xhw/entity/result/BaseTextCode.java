package me.xhw.entity.result;

/**
 * @author 许德承
 * @date 2022/4/8 10:06
 */
public enum BaseTextCode {

    NO_PERMISSION("000104", "没有权限"),
    LOGIN_SUCCESS("000105", "登陆成功"),
    ACCOUNT_NOT_EXIST("000106", "账户不存在"),
    PASS_NOT_MATCH("000107", "密码错误"),
    USER_FORBIDDEN("000108", "账户被禁用"),
    ;


    public String code;
    public String text;

    private BaseTextCode(String code, String text) {
        this.code = code;
        this.text = text;
    }
}
