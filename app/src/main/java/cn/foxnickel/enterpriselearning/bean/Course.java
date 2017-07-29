package cn.foxnickel.enterpriselearning.bean;

import android.support.annotation.NonNull;

/**
 * Created by Night on 2017/7/22.
 * Desc:
 */

public class Course implements Comparable<Course> {
    private String mCourseName;
    private String mCoursePic;
    private float mCourseStars;

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
}
