package dao;

public class Project {
    private String name;
    private String url;
    private String description;

    private int starCount;
    private int forkCount;
    private int openIssueCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setForkCount(int forkCount) {
        this.forkCount = forkCount;
    }

    public void setOpenIssueCount(int openIssueCount) {
        this.openIssueCount = openIssueCount;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public int getStarCount() {
        return starCount;
    }

    public int getForkCount() {
        return forkCount;
    }

    public int getOpenIssueCount() {
        return openIssueCount;
    }
}
