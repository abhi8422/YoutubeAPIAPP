package com.example.youtubeapiapp.YouTubeModel;

public class Items {
    private Snippet snippet;

    private String kind;

    private String etag;

    private Id id;

    public Snippet getSnippet ()
    {
        return snippet;
    }

    public void setSnippet (Snippet snippet)
    {
        this.snippet = snippet;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public Id getId ()
    {
        return id;
    }

    public void setId (Id id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [snippet = "+snippet+", kind = "+kind+", etag = "+etag+", id = "+id+"]";
    }
}
