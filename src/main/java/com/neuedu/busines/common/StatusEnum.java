package com.neuedu.busines.common;

public enum StatusEnum {
    USERNAME_NULL(1, "用户名为空"),
    PASSWORD_NULL(2, "密码为空"),
    EMAIL_NULL(3, "邮箱为空"),
    PHONE_NULL(4, "电话为空"),
    QUESTION_NULL(5, "问题为空"),
    ANSWER_NULL(5, "答案为空"),
    USER_NOT_ONLY(6, "用户名存在"),
    EMAIL_NOT_ONLY(7, "邮箱存在"),
    RESGISTER_FAILED(8, "注册失败"),
    USER_NOT_EMPTY(9, "用户名为空"),
    PASSWORD_NOT_EMPTY(10, "密码为空"),
    USER_NOT_EXIST(11, "用户不存在"),
    USERINFO_UPDATA_FAIL(16, "用户信息更新失败"),
    PARENTID_NOT_NULL(12, "parentId为空"),
    CATEGORYNAME_NOT_NULL(13, "名称为空"),
    CATEGORY_INSERT_FAIL(14, "类别添加失败"),
    CATEGORYID_NOT_NULL(15, "CATEGORYID为空"),
    USER_OUT_LOGIN(100, "用户未登录"),
    NO_AUTHORITY(101, "无访问权限"),
    CATEGORY_NOT_FIND(103, "该分类不存在"),
    CATEGORY_UPDATE_FAIL(104, "名称更新失败"),
    UPLOAD_NAME_NOT_NULL(105, "上传文件名称不能为空"),
    PARAM_NOT_NULL(106, "参数不能为空"),
    PRODUCT_ADD_FAIL(107, "商品添加失败"),
    PRODUCT_NOT_EXISTS(108, "该商品不存在"),
    PRODUCT_UPDATE_FAIL(109, "商品更新失败"),
    PRODUCT_ADD_CART_FAIL(111, "商品添加购物车失败"),
    PRODUCT_UPDATE_CART_FAIL(112, "更新购物车失败"),
    CART_NULL(113, "购物车为空"),
    PRODUCT_NOT_ENOUGH(114, "商品库存不足"),
    ORDER_CREATE_FAIL(115, "订单创建失败"),
    ORDERITEM_CREATE_FAIL(116, "订单明细创建失败"),
    PRODUCE_REDUCE_FAIL(117, "商品扣库存失败"),
    CART_CLEAR_FAIL(118, "购物车清空失败"),
    ORDER_NOT_EXITIS(119, "订单不存在"),
    ORDER_HAS_PAY(121, "订单已付款，无法取消"),
    ORDER_CANCEL_FAIL(122, "订单取消失败"),
    ADDRESS_ADD_FAIL(123, "添加地址失败"),
    ORDER_STATUS_FAIL(124, "订单更新失败"),
    ALIPAY_ORDER_FAIL(37, "支付宝预下单失败"),
    TOKEN_GENERA_FAIL(38, "token生成失败"),
    NOT_CARRY_TOKEN(39, "没有携带token"),
    CANT_REPLEASE(40, "不能重复提交"),
    PHOTO_UPLOAD_FTP_FAIL(41, "文件上传FTP失败"),
    ;
    private int code;

    private String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
