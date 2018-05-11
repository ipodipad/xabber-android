package com.xabber.android.presentation.ui.photogallery;

public class PhotoVO {

    private String url;
    private boolean checked;

    public PhotoVO(String url) {
        this.url = url;
    }

    public PhotoVO(String url, boolean checked) {
        this.url = url;
        this.checked = checked;
    }

    public String getUrl() {
        return url;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
