package cn.foxnickel.enterpriselearning.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Night on 2017/7/22.
 * Desc:
 */

public class Course implements Comparable<Course>, Parcelable {
    private String mCourseName;
    private String mCoursePic;
    private float mCourseStars;
    private List<Chapter> mChapters;
    private int credit;
    private String shortIntro;
    private String courseNotes;
    private String learningWhat;
    private List<Note> mNotes;

    public Course() {
    }

    public Course(String courseName, List<Chapter> chapters, int credit, String shortIntro, String courseNotes, String learningWhat, List<Note> notes) {
        mCourseName = courseName;
        mChapters = chapters;
        this.credit = credit;
        this.shortIntro = shortIntro;
        this.courseNotes = courseNotes;
        this.learningWhat = learningWhat;
        mNotes = notes;
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            Course course = new Course();
            course.setCourseName(in.readString());
            course.setChapters(new ArrayList<Chapter>());
            in.readList(course.getChapters(), getClass().getClassLoader());
            course.setNotes(new ArrayList<Note>());
            in.readList(course.getNotes(), getClass().getClassLoader());
            course.setCredit(in.readInt());
            course.setShortIntro(in.readString());
            course.setCourseNotes(in.readString());
            course.setLearningWhat(in.readString());
            return course;
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getLastLearningTime() {
        return lastLearningTime;
    }

    public void setLastLearningTime(String lastLearningTime) {
        this.lastLearningTime = lastLearningTime;
    }

    private String lastLearningTime;

    public int getLearningRate() {
        return mLearningRate;
    }

    public void setLearningRate(int learningRate) {
        mLearningRate = learningRate;
    }

    private int mLearningRate;

    public Course(String courseName, String coursePic, float courseStars) {
        mCourseName = courseName;
        mCoursePic = coursePic;
        mCourseStars = courseStars;
    }

    public Course(String courseName, String coursePic, float courseStars, String lastLearningTime, int learningRate) {
        mCourseName = courseName;
        mCoursePic = coursePic;
        mCourseStars = courseStars;
        this.lastLearningTime = lastLearningTime;
        mLearningRate = learningRate;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public String getCoursePic() {
        return mCoursePic;
    }

    public void setCoursePic(String coursePic) {
        mCoursePic = coursePic;
    }

    public float getCourseStars() {
        return mCourseStars;
    }

    public void setCourseStars(float courseStars) {
        mCourseStars = courseStars;
    }


    @Override
    public int compareTo(@NonNull Course o) {
        float i = getCourseStars() - o.getCourseStars();
        return (int) i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCourseName);
        dest.writeList(mChapters);
        dest.writeList(mNotes);
        dest.writeInt(credit);
        dest.writeString(shortIntro);
        dest.writeString(courseNotes);
        dest.writeString(learningWhat);
    }

    public List<Chapter> getChapters() {
        return mChapters;
    }

    public void setChapters(List<Chapter> chapters) {
        mChapters = chapters;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public String getLearningWhat() {
        return learningWhat;
    }

    public void setLearningWhat(String learningWhat) {
        this.learningWhat = learningWhat;
    }

    public List<Note> getNotes() {
        return mNotes;
    }

    public void setNotes(List<Note> notes) {
        mNotes = notes;
    }
}
