package com.panch.bookstore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@TableName("b_user")
public class User implements Serializable {
    public static final int NormalUser = 1;
    public static final int DemoUser = 2;
    public static final int AdminUser = 3;

    @TableId(value = "id",type = IdType.AUTO)
    public String id;
    @TableField
    public String username;
    @TableField
    public String password;//密码
    @TableField(exist = false)
    public String rePassword;//确认密码
    @TableField
    public String nickname;//昵称
    @TableField
    public String mobile;
    @TableField
    public String email;
    @TableField
    public String description;//描述
    @TableField
    public String role;//角色
    @TableField
    public String status;//状态
    @TableField
    public String score;//积分
    @TableField
    public String avatar;//头像
    @TableField(exist = false)
    public MultipartFile avatarFile;//头像文件
    @TableField
    public String token;
    @TableField
    public String createTime;
    @TableField
    public String pushEmail;//推送邮箱
    @TableField
    public String pushSwitch;//推送开关



}
