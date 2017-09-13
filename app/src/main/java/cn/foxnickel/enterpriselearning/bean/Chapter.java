package cn.foxnickel.enterpriselearning.bean;

import java.io.Serializable;

import cn.foxnickel.enterpriselearning.utils.Resources;

/**
 * Created by Night on 2017/9/9.
 * Desc:章节
 */

public class Chapter implements Serializable {
    private String mChapterName;
    private boolean isChapter;//true：章 false:节
    private Resources mResources;
    private String url;

    public Chapter(String chapterName, boolean isChapter, Resources resources, String url) {
        mChapterName = chapterName;
        this.isChapter = isChapter;
        mResources = resources;
        this.url = url;
    }

    public String getChapterName() {
        return mChapterName;
    }

    public void setChapterName(String chapterName) {
        mChapterName = chapterName;
    }

    public boolean isChapter() {
        return isChapter;
    }

    public void setChapter(boolean chapter) {
        isChapter = chapter;
    }

    public Resources getResources() {
        return mResources;
    }

    public void setResources(Resources resources) {
        mResources = resources;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
