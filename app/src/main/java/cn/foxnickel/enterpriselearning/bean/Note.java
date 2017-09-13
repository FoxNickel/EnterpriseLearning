package cn.foxnickel.enterpriselearning.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by Night on 2017/7/23.
 * Desc:Note bean
 */
@Entity
public class Note implements Serializable {
    static final long serialVersionUID = 42L;
    @Property(nameInDb = "NormalUserID")
    private int mNormalUserID;
    @Property(nameInDb = "CourseId")
    private int mCourseId;
    @Property(nameInDb = "Source")
    private String mSource;
    @Property(nameInDb = "Content")
    private String mContent;

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    private String mTime;

    public Note(String source, String content, String time) {
        mSource = source;
        mContent = content;
        mTime = time;
    }

    @Generated(hash = 364999443)
    public Note(int mNormalUserID, int mCourseId, String mSource, String mContent,
                String mTime) {
        this.mNormalUserID = mNormalUserID;
        this.mCourseId = mCourseId;
        this.mSource = mSource;
        this.mContent = mContent;
        this.mTime = mTime;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }


    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getMNormalUserID() {
        return this.mNormalUserID;
    }

    public void setMNormalUserID(int mNormalUserID) {
        this.mNormalUserID = mNormalUserID;
    }

    public int getMCourseId() {
        return this.mCourseId;
    }

    public void setMCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getMSource() {
        return this.mSource;
    }

    public void setMSource(String mSource) {
        this.mSource = mSource;
    }

    public String getMContent() {
        return this.mContent;
    }

    public void setMContent(String mContent) {
        this.mContent = mContent;
    }

    public String getMTime() {
        return this.mTime;
    }

    public void setMTime(String mTime) {
        this.mTime = mTime;
    }


}
