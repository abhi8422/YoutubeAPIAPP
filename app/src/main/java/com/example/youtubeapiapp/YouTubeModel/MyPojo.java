package com.example.youtubeapiapp.YouTubeModel;

public class MyPojo {
    private String regionCode;

    private String kind;

   // private PageInfo pageInfo;

    private String etag;

    private Items[] items;

    public String getRegionCode ()
    {
        return regionCode;
    }

    public void setRegionCode (String regionCode)
    {
        this.regionCode = regionCode;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    /*public PageInfo getPageInfo ()
    {
        return pageInfo;
    }

    public void setPageInfo (PageInfo pageInfo)
    {
        this.pageInfo = pageInfo;
    }*/

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [regionCode = "+regionCode+", kind = "+kind+", pageInfo = "+", etag = "+etag+", items = "+items+"]";
    }
}
