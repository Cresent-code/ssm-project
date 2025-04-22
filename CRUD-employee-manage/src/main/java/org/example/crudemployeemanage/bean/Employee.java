package org.example.crudemployeemanage.bean;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {
    private Integer id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "未到合法工作年龄")
    @Max(value = 100, message = "年龄不能超过100岁")
    private Integer age;
    @Email(message = "邮箱格式不正确")
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
