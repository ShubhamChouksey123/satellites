package com.shubham.app.render;

import org.springframework.ui.Model;

import java.math.BigInteger;

public interface RenderLauncherTemplate {
    void renderAllLaunchers(Model model, BigInteger pageNumber, BigInteger pageSize, String searchText);

    void renderDesiredLauncherEditPage(String questionId, Model model);
}
