package cn.foxnickel.enterpriselearning.bean;

/**
 * Created by Night on 2017/7/18.
 * Desc:
 */

public class Exam {
    //试题名称
    private String examName;
    //开始时间到截止时间
    private String startAndEndTime;
    //考试限制时间（单位、分）
    private String timeLimit;
    //对应试题库的表名
    private String examTable;
    //考试题目数量
    private int examLimit;
    //是否已经关闭了该考试
    private Boolean isExaming;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    private int grade = 0;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getStartAndEndTime() {
        return startAndEndTime;
    }

    public void setStartAndEndTime(String startAndEndTime) {
        this.startAndEndTime = startAndEndTime;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getExamTable() {
        return examTable;
    }

    public void setExamTable(String examTable) {
        this.examTable = examTable;
    }

    public int getExamLimit() {
        return examLimit;
    }

    public void setExamLimit(int examLimit) {
        this.examLimit = examLimit;
    }

    public Boolean getExaming() {
        return isExaming;
    }

    public void setExaming(Boolean examing) {
        isExaming = examing;
    }
}
