package validator.po;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by Super腾 on 2017/1/9.
 */

public class User implements Serializable{
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "[0-9a-zA-Z]{6,30}",message = "password format wrong")
    private String password;
    @Length(min =2,max=10,message = "realName illegal")
    private String realName;
    @NotEmpty(message = "age cannot be empty")
    @Pattern(regexp="[0-9]{1,3}",message = "age illegal")
    private String age;
    @Email(message = "email illegal")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
