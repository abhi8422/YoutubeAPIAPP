package com.example.youtubeapiapp.YouTubeModel;

public class Thumbnails {
    //private Default default;

    private High high;

    //private Medium medium;

    /*public Default getDefault ()
    {
        return default;
    }

    public void setDefault (Default default)
    {
        this.default = default;
    }*/

    public High getHigh ()
    {
        return high;
    }

    public void setHigh (High high)
    {
        this.high = high;
    }

    /*public Medium getMedium ()
    {
        return medium;
    }

    public void setMedium (Medium medium)
    {
        this.medium = medium;
    }*/

    @Override
    public String toString()
    {
        return "ClassPojo [default = "+", high = "+high+", medium = "+"]";
    }
}
