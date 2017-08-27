package cn.foxnickel.enterpriselearning.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Night on 2017/8/26.
 * Desc:
 */
@Entity
public class NormalUser {
    @Id
    @Property(nameInDb = "ID")
    private Long id;//ID

    @Property(nameInDb = "Position")
    private String position;//职位

    @Property(nameInDb = "Department")
    private String department;

    @Property(nameInDb = "Name")
    private String name;

    @Property(nameInDb = "Phone")
    private int phone;//手机号

    @Property(nameInDb = "Email")
    private String email;//邮件

    @Property(nameInDb = "Password")
    @NotNull
    private String password;

    @Property(nameInDb = "Avatar")
    private String avatar;//头像路径

    @Generated(hash = 1748423893)
    public NormalUser(Long id, String position, String department, String name,
                      int phone, String email, @NotNull String password, String avatar) {
        this.id = id;
        this.position = position;
        this.department = department;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
    }

    @Generated(hash = 1365037757)
    public NormalUser() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
