package com.liuwill.simpleMyBatis.entity;

public class CommonCommentModelWithBLOBs extends CommonCommentModel {
    private String commentAuthor;

    private String commentContent;

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}