package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/21.
 * Desc:
 */

public class CourseRecommend {
    private String CourseName;
    private String ChapterTitle;
    private String ChapterDescription;
    private String LearningNumber;

    public CourseRecommend(String courseName, String chapterTitle, String chapterDescription, String learningNumber) {
        CourseName = courseName;
        ChapterTitle = chapterTitle;
        ChapterDescription = chapterDescription;
        LearningNumber = learningNumber;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getChapterTitle() {
        return ChapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        ChapterTitle = chapterTitle;
    }

    public String getChapterDescription() {
        return ChapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        ChapterDescription = chapterDescription;
    }

    public String getLearningNumber() {
        return LearningNumber;
    }

    public void setLearningNumber(String learningNumber) {
        LearningNumber = learningNumber;
    }
}
