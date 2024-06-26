package DesignPatterns.Patterns.TemplateMethodPattern.templatemethod.applet;

import java.awt.*;
import java.awt.image.ColorModel;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Locale;

public class Applet extends Panel {
    transient private AppletStub stub;
    public final void setStub(AppletStub stub) {
    this.stub = (AppletStub)stub;
    }
    public boolean isActive() {
    if (stub != null) {
        return stub.isActive();
    } else {        // If stub field not filled in, applet never active
        return false;
    }
    }
    public URL getDocumentBase() {
    return stub.getDocumentBase();
    }
    public URL getCodeBase() {
    return stub.getCodeBase();
    }
     public String getParameter(String name) {
     return stub.getParameter(name);
     }
    public AppletContext getAppletContext() {
    return stub.getAppletContext();
    }
    public void resize(int width, int height) {
    Dimension d = size();
    if ((d.width != width) || (d.height != height)) {
        super.resize(width, height);
        if (stub != null) {
            stub.appletResize(width, height);
        }
    }
    }
    public void resize(Dimension d) {
    resize(d.width, d.height);
    }
    public void showStatus(String msg) {
    getAppletContext().showStatus(msg);
    }
    public Image getImage(URL url) {
    return getAppletContext().getImage(url);
    }
    public Image getImage(URL url, String name) {
    try {
        return getImage(new URL(url, name));
    } catch (MalformedURLException e) {
        return null;
    }
    }
    public AudioClip getAudioClip(URL url) {
    return getAppletContext().getAudioClip(url);
    }
    public AudioClip getAudioClip(URL url, String name) {
    try {
        return getAudioClip(new URL(url, name));
    } catch (MalformedURLException e) {
        return null;
    }
    }
    public String getAppletInfo() {
    return null;
    }
    public Locale getLocale() {
      Locale locale = super.getLocale();
      if (locale == null) {
    return Locale.getDefault();
      }
      return locale;
    }
    public String[][] getParameterInfo() {
    return null;
    public void play(URL url) {
    AudioClip clip = getAudioClip(url);
    if (clip != null) {
        clip.play();
    }
    }
    public void play(URL url, String name) {
    AudioClip clip = getAudioClip(url, name);
    if (clip != null) {
        clip.play();
    }
    }
    public void init() {
    }
    public void start() {
    }
    public void stop() {
    }
    public void destroy() {
}
}

