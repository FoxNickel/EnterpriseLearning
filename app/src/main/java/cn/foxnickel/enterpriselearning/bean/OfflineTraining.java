package cn.foxnickel.enterpriselearning.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Night on 2017/8/26.
 * Desc:
 */
@Entity
public class OfflineTraining {
    @Id(autoincrement = true)
    @Property(nameInDb = "ID")
    private Long id;//ID

    @Property(nameInDb = "Name")
    @NotNull
    private String name;

    @Property(nameInDb = "Introduction")
    @NotNull
    private String introduction;

    @Property(nameInDb = "Number")
    @NotNull
    private int number;

    @Property(nameInDb = "Place")
    @NotNull
    private String place;

    @Property(nameInDb = "StartingTime")
    @NotNull
    private java.util.Date startingTime;

    @Property(nameInDb = "Druation")
    @NotNull
    private int druation;

    @Property(nameInDb = "Image")
    @NotNull
    private String image;

    @Generated(hash = 1703168370)
    public OfflineTraining(Long id, @NotNull String name,
                           @NotNull String introduction, int number, @NotNull String place,
                           @NotNull java.util.Date startingTime, int druation,
                           @NotNull String image) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.number = number;
        this.place = place;
        this.startingTime = startingTime;
        this.druation = druation;
        this.image = image;
    }

    @Generated(hash = 1211586112)
    public OfflineTraining() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public java.util.Date getStartingTime() {
        return this.startingTime;
    }

    public void setStartingTime(java.util.Date startingTime) {
        this.startingTime = startingTime;
    }

    public int getDruation() {
        return this.druation;
    }

    public void setDruation(int druation) {
        this.druation = druation;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
