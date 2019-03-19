package com.xianke.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 枚举异常
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    INVALID_FILE_FORMAT(400, "文件格式错误"),
    UPLOAD_IMAGE_EXCEPTION(500, "文件上传异常"),
    INVALID_PARAM(400, "参数错误"),
    USERNAME_OR_PASSWORD_ERROR(400, "账号或密码错误"),
    VERIFY_CODE_NOT_MATCHING(400, "验证码错误"),
    PASSWORD_NOT_MATCHING(400, "密码错误"),
    USER_NOT_EXIST(404, "用户不存在"),
    USER_NOT_FONUND(404, "用户没有找到"),
    NEWS_NOT_FONUND(404, "新闻没有找到"),

    NEWS_ADD_ERROR(400, "新闻增加失败"),
    NEWS_UPDATE_ERROR(500, "新闻更新失败"),
    NEWS_DELETE_ERROR(500, "删除新闻失败"),




    ;
    int value;
    String message;

    public int value() {
        return this.value;
    }

    public String message() {
        return this.message;
    }


}
